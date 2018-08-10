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
import java.util.List;

@WebAPI("/api/portal/vehicleModel")
public class VehicleModelEsAPI {

    @Resource
    private VehicleModelEsRepository vehicleModelEsRepository;

    @PostMapping("/create")
    public VehicleModel create(@RequestBody VehicleModel vehicleModel){
        vehicleModelEsRepository.create(vehicleModel);
        return vehicleModel;
    }

    @GetMapping("/delete")
    public void delete(@RequestParam String index,
                       @RequestParam String type,
                       @RequestParam String id){
        vehicleModelEsRepository.delete(index,type,id);
    }

    @PostMapping("/search")
    public List<VehicleModel> modelSearch(@RequestBody VehicleModelParam vehicleModelParam){
        return vehicleModelEsRepository.modelSearch(vehicleModelParam);
    }
}
