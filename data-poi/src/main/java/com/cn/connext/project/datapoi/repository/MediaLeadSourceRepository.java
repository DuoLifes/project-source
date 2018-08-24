package com.cn.connext.project.datapoi.repository;

import com.cn.connext.project.datapoi.entity.MediaLeadSource;
import com.cn.connext.project.datapoi.excelUtil.ExportHeaderUtil;
import com.cn.connext.project.datapoi.excelUtil.ExportToExcelUtil;
import com.cn.connext.project.startelasticsearch.ElasticSearchBase;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class MediaLeadSourceRepository extends ElasticSearchBase{
    @Resource
    private ExportHeaderUtil exportHeaderUtil;
    @Resource
    private ExportToExcelUtil exportToExcelUtil;

    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
    private String index = "medialeadsource-" + dateFormater.format(new Date());
    private String type = "mediaLeadsource";

    public MediaLeadSource create(MediaLeadSource mediaLeadSource) {
        createDocument(index, type, null, mediaLeadSource);
        return mediaLeadSource;
    }

    public FileOutputStream exportByEs(FileOutputStream outputStream) {
        QueryBuilder queryBuilder = null;
        SearchRequestBuilder builder = client
                .prepareSearch(index)
                .setTypes(type)
                .setQuery(queryBuilder)
                .setFrom(0)
                .setSize(1000);
        SearchResponse searchResponse = builder.execute().actionGet();
        try {
            outputStream = exportHeaderUtil.exportHeader(outputStream);//组装表头
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        while (true) {
            if (searchResponse.getHits().getTotalHits() != 0) {
                try {
                    outputStream = exportToExcelUtil.export(searchResponse, outputStream);//组装数据
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
//            searchResponse = client.prepareSearchScroll(searchResponse.getScrollId())
//                    .setScroll(TimeValue.timeValueSeconds(60 * 5))//深分页，查询快照，效率高，遍历全部数据
//                    .execute().actionGet();
//            if (searchResponse.getHits().getHits().length == 0) {
//                break;
//            }
            return outputStream;
        }
        //return outputStream;
    }
}
