package com.cn.connext.project.multidatasource.webapi.sqlserver;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.entity.sqlserver.TMDealer;
import com.cn.connext.project.multidatasource.service.sqlserver.TMDealerService;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/multi-datasource/tMDealer")
public class TMDealerAPI {

    @Resource
    private TMDealerService tmDealerService;

    @GetMapping("/findAll")
    public List<TMDealer> findAllTMDealer() {
        return tmDealerService.finAll();
    }
}