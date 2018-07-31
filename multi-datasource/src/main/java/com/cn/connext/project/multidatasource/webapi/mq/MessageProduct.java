package com.cn.connext.project.multidatasource.webapi.mq;


import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.multidatasource.mq.MultiDataSourceProductor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@WebAPI("/api/multi-datasource/send")
public class MessageProduct {

    @Resource
    private MultiDataSourceProductor multiDataSourceProductor;

    @GetMapping
    public void sendMessage(@RequestParam String msg){
        multiDataSourceProductor.send(msg);
    }
}
