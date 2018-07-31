package com.cn.connext.project.basic.webapi;

import com.cn.connext.project.basic.entity.Dealer;
import com.cn.connext.project.basic.service.DealerService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


/**
 * 经销商信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/basic/dealer")
public class DealerAPI {

    /**
     * 经销商信息 - 业务服务对象
     */
    @Resource
    private DealerService dealerService;

    @GetMapping("/findAll")
    public List<Dealer> findAll(){
        return dealerService.findAll();
    }

}

