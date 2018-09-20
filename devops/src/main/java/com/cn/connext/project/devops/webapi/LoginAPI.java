package com.cn.connext.project.devops.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAPI {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
