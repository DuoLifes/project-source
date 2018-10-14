package com.cn.connext.project.devops.webapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class LoginAPI {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
