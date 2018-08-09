package com.cn.connext.project.common.client;

import com.cn.connext.project.common.dto.PartnerDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 张帅
 * @version 2018/08/09 09:10
 */
@FeignClient(name = "basic", path = "/api/basic/partner")
public interface PartnerClient {

    @GetMapping("/findAll")
    List<PartnerDTO> findAll();
}
