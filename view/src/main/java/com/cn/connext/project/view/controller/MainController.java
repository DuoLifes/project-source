package com.cn.connext.project.view.controller;

import com.cn.connext.project.view.pojo.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @ResponseBody
    @RequestMapping("/search")
    public String search(@RequestParam("username")String username, @RequestParam("password")String password, Model model){
        Gson gson = new Gson();
        User u1=new User("001","张三","123456");
        User u2=new User("002","里斯","654321");
        User u3=new User("003","李白","223355");
        List<User> list=new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        return gson.toJson(list);
    }
}
