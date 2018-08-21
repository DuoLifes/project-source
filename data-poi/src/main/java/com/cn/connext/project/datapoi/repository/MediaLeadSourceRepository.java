package com.cn.connext.project.datapoi.repository;

import com.cn.connext.project.datapoi.entity.MediaLeadSource;
import com.cn.connext.project.startelasticsearch.ElasticSearchBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class MediaLeadSourceRepository {

    private String index;

    private String type;

    @Autowired
    public ElasticSearchBase elasticSearchBase;

    public MediaLeadSource create(MediaLeadSource mediaLeadSource) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        index = "medialeadsource-" + dateFormater.format(new Date());
        type = "mediaLeadsource";
        elasticSearchBase.createDocument(index, type, null, mediaLeadSource);
        return mediaLeadSource;
    }
}
