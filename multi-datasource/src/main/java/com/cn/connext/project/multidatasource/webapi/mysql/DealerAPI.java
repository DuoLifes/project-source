package com.cn.connext.project.multidatasource.webapi.mysql;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.entity.mysql.Dealer;
import com.cn.connext.project.multidatasource.service.mysql.DealerService;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/multi-datasource/dealer")
public class DealerAPI {

    @Resource
    private DealerService dealerService;

    @GetMapping("/findAll")
    public List<Dealer> findAll(){
        return dealerService.findAll();
    }
}
