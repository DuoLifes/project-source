package com.cn.connext.project.basic.service.relationMybatis.ManyToOne;

import com.cn.connext.project.basic.entity.relationMybatis.ManyToOne.Teacher;
import com.cn.connext.project.basic.repository.relationMybatis.ManyToOne.TeacherBatisRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TeacherBatisService {

    @Resource
    private TeacherBatisRepository teacherBatisRepository;

    public List<Teacher> findAll(){
        return teacherBatisRepository.findAll();
    }
}
