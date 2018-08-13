package com.cn.connext.project.portal.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.portal.domain.VehicleModelParam;
import com.cn.connext.project.portal.entity.VehicleModel;
import com.cn.connext.project.portal.repository.VehicleModelEsRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebAPI("/api/portal/vehicleModel")
public class VehicleModelEsAPI {

    @Resource
    private VehicleModelEsRepository vehicleModelEsRepository;
    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMM");
    private  String index = "vehiclemodel-" + dateFormater.format(new Date());
    private  String type = "vehiclemodel";


    //创建文档
    @PostMapping("/create")
    public VehicleModel create(@RequestBody VehicleModel vehicleModel){
        vehicleModelEsRepository.createDocument(index,type,null,vehicleModel);
        return vehicleModel;
    }

    //删除文档
    @DeleteMapping("/delete")
    public void delete(@RequestBody VehicleModelParam vehicleModelParam){
        vehicleModelEsRepository.deleteDocument(index,type,vehicleModelParam.id);
    }

    //更新文档(可以传入多个需要更新的字段)
    @PutMapping("/update")
    public void update(@RequestBody VehicleModelParam vehicleModelParam){
        Map<String,Object> map = new HashMap();
        map.put("name",vehicleModelParam.name);
        map.put("code",vehicleModelParam.code);
        vehicleModelEsRepository.updateDocument(index,type,vehicleModelParam.id,map);
    }

    //分页查询
    @PostMapping("/findPage")
    public Page<VehicleModel> findPage(@RequestBody VehicleModelParam vehicleModelParam){
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("name", vehicleModelParam.name));
        return vehicleModelEsRepository.findPage(index,type,queryBuilder,new PageRequest(0,2),VehicleModel.class);
    }


    //查询文档（自定义方法)
    @PostMapping("/search")
    public List<VehicleModel> modelSearch(@RequestBody VehicleModelParam vehicleModelParam){
        return vehicleModelEsRepository.modelSearch(vehicleModelParam);
    }
}
