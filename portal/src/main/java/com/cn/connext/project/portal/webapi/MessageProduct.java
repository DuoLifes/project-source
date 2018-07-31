package com.cn.connext.project.portal.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.portal.mq.PortalDataSourceProductor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@WebAPI("/api/portal/send")
public class MessageProduct {

    @Resource
    private PortalDataSourceProductor portalDataSourceProductor;

    @GetMapping
    public void sendMessage(@RequestParam String msg){
        portalDataSourceProductor.send(msg);
    }
}
