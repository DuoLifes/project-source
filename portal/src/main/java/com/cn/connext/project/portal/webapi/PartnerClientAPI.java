package com.cn.connext.project.portal.webapi;

import com.cn.connext.project.common.client.PartnerClient;
import com.cn.connext.project.common.dto.PartnerDTO;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/portal/partner")
public class PartnerClientAPI {

    @Resource
    private PartnerClient partnerClient;

    @GetMapping("/findAll")
    public List<PartnerDTO> findAll(){
        return partnerClient.findAll();
    }
}
