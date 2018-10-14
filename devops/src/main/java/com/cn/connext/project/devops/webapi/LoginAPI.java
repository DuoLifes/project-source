package com.cn.connext.project.devops.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/start")
public class LoginAPI {

    @RequestMapping("/aaa")
    public String bbb(){
        return "login";
    }
}
