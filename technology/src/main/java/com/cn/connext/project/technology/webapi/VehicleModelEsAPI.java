package com.cn.connext.project.technology.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.technology.repository.VehicleModelEsRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebAPI("/api/technology/vehicleModel")
public class VehicleModelEsAPI {

    @Resource
    private VehicleModelEsRepository vehicleModelEsRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleModelEsRepository.class);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
    private String index = "vehiclemodel-" + dateFormater.format(new Date());
    private String type = "vehiclemodel";

    @GetMapping("/count")
    public long count() {
        QueryBuilder queryBuilder = null;
        return vehicleModelEsRepository.count(index, type, queryBuilder);
    }
}
