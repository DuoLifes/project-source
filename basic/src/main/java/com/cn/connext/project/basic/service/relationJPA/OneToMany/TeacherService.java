package com.cn.connext.project.basic.service.relationJPA.OneToMany;

import com.cn.connext.project.basic.entity.relationJPA.OneToMany.Teacher;
import com.cn.connext.project.basic.repository.relationJPA.OneToMany.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherService {
    @Resource
    private TeacherRepository teacherRepository;

    //验证级联增加
    public Teacher create(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    //删除
    public void delete(String name){
        teacherRepository.deleteByName(name);
    }

    //验证级联修改
    public Teacher update(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    //查询
    public Teacher findByName(String name){
        return teacherRepository.findByName(name);
    }

}
