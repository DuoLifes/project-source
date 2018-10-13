package com.cn.connext.project.view.controller;

import com.cn.connext.project.view.entity.Partner;
import com.cn.connext.project.view.service.PartnerService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Resource
    private PartnerService partnerService;

    @ResponseBody
    @RequestMapping("/search")
    public String search(@RequestParam("username")String username, @RequestParam("password")String password){
        Gson gson = new Gson();
        if("张三".equals(username)&&"123456".equals(password)){
            List<Partner> list = partnerService.findList();
            return gson.toJson(list);
        }
        Object o=null;
        return gson.toJson(o);
    }
}
