package com.cn.connext.project.basic.webapi.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.service.relationJPA.OneToOne.StudentService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@WebAPI("/api/basic/oneToOne/student")
public class StudentAPI {
    @Resource
    private StudentService studentService;

    //验证级联增加
    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    //验证级联修改
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }

    //验证级联删除
    @GetMapping("/delete")
    public void delete(@RequestParam String name){
        studentService.delete(name);
    }

    //查询
    @GetMapping("/findByName")
    public Student findStudent(@RequestParam String name){
        return studentService.findByName(name);
    }

}
