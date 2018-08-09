package com.cn.connext.project.basic.webapi;


import com.cn.connext.project.basic.domain.PageAble;
import com.cn.connext.project.basic.entity.Partner;
import com.cn.connext.project.basic.service.PartnerService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebAPI("/api/basic/partner")
public class PartnerAPI {

    @Resource
    private PartnerService partnerService;

    @GetMapping("/findByCode")
    public List<Partner> findByCode(@RequestParam String code){
        return partnerService.findByCode(code);
    }

    @GetMapping
    public List<Partner> findIdAndName(){
        return partnerService.findIdAndName();
    }

    @PostMapping("/selectByCode")
    public List<Partner> selectByCode(@RequestBody Partner partner){
        return partnerService.selectByCode(partner.getCode());
    }

    @GetMapping("/findAll")
    public List<Partner> findAll(){
        return partnerService.findAll();
    }

    //分页查询1
    @GetMapping("/findByPage")
    public List<Partner> findByPage(@RequestParam (required = false)Integer page,
                                    @RequestParam (required = false)Integer size){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("page",page);
        map.put("size",size);
        return partnerService.findByPage(map);
    }

    //分页查询2
    @GetMapping("/findPage")
    public List<Partner> PageAble(@RequestParam (required = false)Integer page,
                                 @RequestParam (required = false)Integer size){
        PageAble pageAble=new PageAble();
        pageAble.setPage(page);
        pageAble.setSize(size);
        pageAble.setBegin((page-1)*size);
        return partnerService.findPage(pageAble);
    }

    //分组聚合
    @GetMapping("/group")
    public List<Partner> findGroup(){
        return partnerService.findGroup();
    }
}
