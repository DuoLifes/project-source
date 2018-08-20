package com.cn.connext.project.basic.service.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.repository.relationJPA.OneToOne.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    //验证级联增加
    public Student save(Student student){
        return studentRepository.save(student);
    }

    //验证级联删除
    public void delete(String name){
        studentRepository.deleteByName(name);
    }

    //验证级联修改
    public void update(Student student){
        studentRepository.save(student);
    }

    //查询
    public Student findByName(String name){
        return studentRepository.findByName(name);
    }

}
