package com.cn.connext.project.ibatisbasic.service;

import com.cn.connext.project.ibatisbasic.entity.Teacher;
import com.cn.connext.project.ibatisbasic.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/*
*   Mybatis多对一映射
*/

@Service
public class TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
}
