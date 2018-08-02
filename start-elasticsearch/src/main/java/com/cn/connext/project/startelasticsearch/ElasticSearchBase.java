package com.cn.connext.project.startelasticsearch;

import com.cn.connext.project.framework.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"unchecked", "Duplicates"})
public class ElasticSearchBase {

    @Autowired
    protected TransportClient client;

    Logger logger = LoggerFactory.getLogger(ElasticSearchBase.class);

    /**
     * 新建索引文档
     */
    public IndexResponse create(String index, String type, String id, Object source) {
        ObjectMapper objectMapper = new ObjectMapper();
        String sourceStr;
        try {
            sourceStr = objectMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            return client.prepareIndex(index, type, id)
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    .setSource(sourceStr, XContentType.JSON).execute().actionGet();
        } catch (NoNodeAvailableException e) {
            throw e;
        }
    }

    public void delete(String index,String type,String id){
        try{
            client.prepareDelete(index,type,id).execute().actionGet();
        }catch (Exception e){
            logger.info("删除失败："+e.toString());
        }
    }

    /**
     * 更新文档
     */
    public void update(String index, String type, String id, Map<String, Object> maps) {
        ObjectMapper objectMapper = new ObjectMapper();
        String sourceStr = "";
        try {
            sourceStr = objectMapper.writeValueAsString(maps);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean isFinish = false;
        int retryTimes = 0;
        while (!isFinish && retryTimes < 3) { // 防止高并发更新写入情况下，ES版本冲突，自动重试3次
            try {
                client.prepareUpdate(index, type, id)
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                        .setDoc(sourceStr, XContentType.JSON)
                        .execute().actionGet();
                isFinish = true;
            } catch (Exception e) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                retryTimes++;
                if (retryTimes >= 3) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 根据文档Id获取索引名        入参索引支持 *
     *
     * @param id
     * @param index
     * @param type
     * @return
     */
    protected String getModifyIndexName(String index, String type, String id) {
        boolean isFoundIndex = false;
        int retryTimes = 0;
        while (!isFoundIndex && retryTimes < 3) { // 防止高并发更新写入情况下，ES版本冲突，自动重试3次
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("_id", id));
            SearchResponse searchResponse = client
                    .prepareSearch(index)
                    .setTypes(type)
                    .setPostFilter(boolQueryBuilder)
                    .setFetchSource(new String[]{"0"}, null)
                    .execute()
                    .actionGet();

            SearchHits hits = searchResponse.getHits();
            isFoundIndex = hits.totalHits > 0;
            if (isFoundIndex) {
                return hits.getAt(0).getIndex();
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                retryTimes++;
            }
        }
        throw new RuntimeException("can not find leads by leadsId:" + id);
    }


    /**
     * 分页查询
     */
    public <T> Page<T> findPage(String index, String type, QueryBuilder queryBuilder, Pageable pageable, Class<T> clazz) {
        SearchRequestBuilder builder = client
                .prepareSearch(index)
                .setTypes(type)
                .setQuery(queryBuilder)
                .setFrom(pageable.getPageNumber() * pageable.getPageSize())
                .setSize(pageable.getPageSize());

        if (pageable.getSort() != null) {
            Sort sort = pageable.getSort();
            for (Sort.Order order : sort) {
                String sortField = order.getProperty();
                SortOrder sortOrder = order.getDirection().isDescending() ? SortOrder.DESC : SortOrder.ASC;
                builder.addSort(sortField, sortOrder);
            }
        }

//        ElasticSearchDocument elasticSearchDocument = clazz.getAnnotation(ElasticSearchDocument.class);
//        if (elasticSearchDocument != null) {
//
//        }

        List<T> list = new ArrayList();
        SearchResponse searchResponse = builder.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        for (SearchHit searchHit : hits) {
            try {
                T t = JSON.parseObject(searchHit.getSourceAsString(), clazz);
                if (t == null) {
                    continue;
                }
                list.add(t);
            } catch (Exception ex) {
                throw new RuntimeException("Convert json from elasticSearch to object error:", ex);
            }
        }
        return new PageImpl<>(list, pageable, hits.getTotalHits());
    }


    public long count(String index, String type, QueryBuilder queryBuilder) {
        return client.prepareSearch(index)
                .setTypes(type)
                .setSize(0)
                .setQuery(queryBuilder).get().getHits().getTotalHits();
    }


    //分组查询
    public Map<String, Integer> countGroup(String index, String type, String groupName, String field, QueryBuilder queryBuilder) {

        //构造分组字段及别名groupName 、field
        TermsAggregationBuilder tb = AggregationBuilders.terms(groupName).field(field);
        SearchRequestBuilder builder = client.prepareSearch(index)
                .setTypes(type)
                .setQuery(queryBuilder)
                .addAggregation(tb);
        SearchResponse searchResponse = builder.execute()
                .actionGet();
        Terms terms = searchResponse.getAggregations().get(groupName);
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        Map<String, Integer> dataMap = new HashMap<String, Integer>();
        for (Terms.Bucket bucket : buckets) {
            String key = (String) bucket.getKey();
            dataMap.put(key, (int) bucket.getDocCount());

            //System.out.println("key"+key+"================"+ (int) bucket.getDocCount());
        }


        return dataMap;
    }

    //查询
    public <T> List<T> findList(String index, String type,QueryBuilder queryBuilder,Class<T> clazz) {

        SearchRequestBuilder builder = client
                .prepareSearch(index)
                .setTypes(type)
                .setQuery(queryBuilder);

        List<T> list = new ArrayList();
        SearchResponse searchResponse = builder.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        for (SearchHit searchHit : hits) {
            try {
                T t = JSON.parseObject(searchHit.getSourceAsString(), clazz);
                if (t == null) {
                    continue;
                }
                list.add(t);
            } catch (Exception ex) {
                throw new RuntimeException("Convert json from elasticSearch to object error:", ex);
            }
        }

        return list;
    }

}
