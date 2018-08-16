package com.cn.connext.project.portal.repository;

import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.portal.domain.VehicleModelParam;
import com.cn.connext.project.portal.entity.VehicleModel;
import com.cn.connext.project.startelasticsearch.ElasticSearchBase;
import com.google.common.collect.Maps;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 张帅
 */
@Repository
public class VehicleModelEsRepository extends ElasticSearchBase{


    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleModelEsRepository.class);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
    private  String index = "vehiclemodel-" + dateFormater.format(new Date());
    private  String type = "vehiclemodel";

    //查询文档（自定义方法）
    public List<VehicleModel> modelSearch(VehicleModelParam vehicleModelParam) {
        //创建And查询容器
        BoolQueryBuilder andQuery = QueryBuilders.boolQuery();
        //创建Or查询容器
        BoolQueryBuilder orQuery = QueryBuilders.boolQuery();
        //构建查询语句
        QueryBuilder updateTimeCondition = QueryBuilders.rangeQuery("updateTime")
                .gte(sdf.format(vehicleModelParam.getBeginUpdateTime()))
                .lt(sdf.format(vehicleModelParam.getEndUpdateTime()))
                .timeZone("+08:00");
        QueryBuilder yearCondition = QueryBuilders.rangeQuery("year")
                .gte(vehicleModelParam.getBeginYear())
                .lt(vehicleModelParam.getEndYear());
        QueryBuilder nameCondition = QueryBuilders.termQuery("name", vehicleModelParam.getName());
        QueryBuilder codeCondition = QueryBuilders.termQuery("code", vehicleModelParam.getCode());
        QueryBuilder isInvalidCondition = QueryBuilders.termQuery("isInvalid", vehicleModelParam.getIsInvalid());
        QueryBuilder extValueCondition = QueryBuilders.termQuery("extValue", vehicleModelParam.getExtValue());
        //组装查询条件
        andQuery.must(updateTimeCondition)
                .must(yearCondition)
                .must(nameCondition);
        orQuery.should(codeCondition)
                .should(isInvalidCondition)
                .should(extValueCondition);
        BoolQueryBuilder mainQuery = QueryBuilders.boolQuery()
                .must(andQuery)
                .must(orQuery);
        //开始查询
        SearchRequestBuilder requestBuilder = client
                .prepareSearch(index)
                .setTypes(type)
                .setQuery(mainQuery)
                .setFrom(0)
                .setSize(10000);
        requestBuilder.addSort("updateTime", SortOrder.DESC);

        //组装查询返回数据
        List<VehicleModel> list = new ArrayList();
        SearchHits hits = requestBuilder.execute().actionGet().getHits();
        for (SearchHit searchHit : hits) {
            try {
                VehicleModel t = JSON.parseObject(searchHit.getSourceAsString(), VehicleModel.class);
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

    //多重聚合（自定义方法）
    public Map<String, Long> countGroups(){
        AggregationBuilder nameAggregation = AggregationBuilders
                .terms("name")
                .field("name")
                .minDocCount(1);

        AggregationBuilder mainAggregation = AggregationBuilders
                .terms("code")
                .field("code")
                .minDocCount(1)
                .subAggregation(nameAggregation);

        SearchRequestBuilder requestBuilder = client
                .prepareSearch(index)
                .setTypes(type)
               // .setQuery(mainQuery)
                .setFrom(0)
                .setSize(10000)
                .addAggregation(mainAggregation);

        Map<String, Long> map = Maps.newHashMap();
        StringTerms codeHistogram = requestBuilder.execute().actionGet().getAggregations().get("code");
        List<StringTerms.Bucket> codeBuckets = codeHistogram.getBuckets();
        codeBuckets.forEach(codebucket -> {
            StringTerms nameHistogram = codebucket.getAggregations().get("name");
            List<StringTerms.Bucket> nameBuckets = nameHistogram.getBuckets();
            nameBuckets.forEach(nameBucket -> {
                    map.put(codebucket.getKey().toString() + "&&" + nameBucket.getKey().toString(), nameBucket.getDocCount());
            });
        });
        return map;
    }

}
