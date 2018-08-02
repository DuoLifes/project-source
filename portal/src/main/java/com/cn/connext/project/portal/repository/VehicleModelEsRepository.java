package com.cn.connext.project.portal.repository;

import com.cn.connext.project.portal.entity.VehicleModel;
import com.cn.connext.project.startelasticsearch.ElasticSearchBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张帅
 */
@Repository
public class VehicleModelEsRepository {

    private String index;

    private String type;

    @Autowired
    public ElasticSearchBase elasticSearchBase;

    public void create(VehicleModel vehicleModel) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
        index = "vehiclemodel-" + dateFormater.format(new Date());
        type = "vehiclemodel";
        elasticSearchBase.create(index, type, null, vehicleModel);
    }

    public void delete(String index,String type,String id){
        elasticSearchBase.delete(index,type,id);
    }

}
