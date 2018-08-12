package com.cn.connext.project.portal.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.portal.domain.VehicleModelParam;
import com.cn.connext.project.portal.entity.VehicleModel;
import com.cn.connext.project.portal.repository.VehicleModelEsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebAPI("/api/portal/vehicleModel")
public class VehicleModelEsAPI {

    @Resource
    private VehicleModelEsRepository vehicleModelEsRepository;

    //创建文档
    @PostMapping("/create")
    public VehicleModel create(@RequestBody VehicleModel vehicleModel){
        vehicleModelEsRepository.create(vehicleModel);
        return vehicleModel;
    }

    //删除文档
    @GetMapping("/delete")
    public void delete(@RequestParam String index,
                       @RequestParam String type,
                       @RequestParam String id){
        vehicleModelEsRepository.delete(index,type,id);
    }

    //更新文档(可以传入多个需要更新的字段)
    @GetMapping("/update")
    public void update(@RequestParam String id,@RequestParam String name,@RequestParam String code){
        Map<String,Object> map = new HashMap();
        map.put("name",name);
        map.put("code",code);
        String index="vehiclemodel-201808";
        String type="vehiclemodel";
        vehicleModelEsRepository.update(index,type,id,map);
    }


    //查询文档
    @PostMapping("/search")
    public List<VehicleModel> modelSearch(@RequestBody VehicleModelParam vehicleModelParam){
        return vehicleModelEsRepository.modelSearch(vehicleModelParam);
    }
}
