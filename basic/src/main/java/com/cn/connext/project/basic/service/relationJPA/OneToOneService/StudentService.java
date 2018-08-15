package com.cn.connext.project.basic.service.relationJPA.OneToOneService;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.repository.relationJPA.OneToOneRepository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    public Student findStudent(String name){
        return studentRepository.findStudent(name);
    }
}
