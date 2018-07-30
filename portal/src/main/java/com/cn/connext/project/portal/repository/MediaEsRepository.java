package com.cn.connext.project.portal.repository;

import com.cn.connext.project.portal.entity.Media;
import com.cn.connext.project.startelasticsearch.ElasticSearchBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangpeiyu
 */
@Repository
public class MediaEsRepository {

    private String index;

    private String type;

    @Autowired
    public ElasticSearchBase elasticSearchBase;

    public void create(Media media) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        index = "media-" + dateFormater.format(new Date());
        type = "media";
        elasticSearchBase.create(index, type, null, media);
    }

}
