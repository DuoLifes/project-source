package com.cn.connext.project.basic.webapi.relationJPA.OneToOneAPI;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.repository.relationJPA.OneToOneRepository.StudentRepository;
import com.cn.connext.project.basic.service.relationJPA.OneToOneService.StudentService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@WebAPI("/api/basic/oneToOne/student")
public class StudentAPI {
    @Resource
    private StudentService studentService;

    @GetMapping("/findStudent")
    public Student findStudent(@RequestParam String name){
        return studentService.findStudent(name);
    }
}
