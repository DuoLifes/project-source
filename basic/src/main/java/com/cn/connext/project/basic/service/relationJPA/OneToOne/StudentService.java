package com.cn.connext.project.basic.service.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.repository.relationJPA.OneToOne.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    public Student findByName(String name){
        return studentRepository.findByName(name);
    }
}
