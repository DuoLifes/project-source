package com.cn.connext.project.view.controller;

import com.cn.connext.project.view.pojo.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/portal")
public class LoginController {

    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/verify")
    public String verify(@RequestParam("username")String username, @RequestParam("password")String password, Model model){
        Gson gson = new Gson();
        User user = new User("001","张三","123456");
        if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
            return gson.toJson(user);
        }
        User u=null;
        return gson.toJson(u);
    }

    @RequestMapping("/main")
    public String main(Model model){
        return "main";
    }

}
