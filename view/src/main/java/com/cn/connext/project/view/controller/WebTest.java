package com.cn.connext.project.view.controller;

import com.cn.connext.project.view.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class WebTest {

    @RequestMapping("/index")
    public String test(Model model){
        model.addAttribute("say","hello world");
        Person person=new Person("001","张三",25);
        model.addAttribute("p1",person);
        return "index";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
