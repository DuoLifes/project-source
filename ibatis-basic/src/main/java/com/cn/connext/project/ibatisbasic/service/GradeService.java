package com.cn.connext.project.ibatisbasic.service;

import com.cn.connext.project.ibatisbasic.entity.Grade;
import com.cn.connext.project.ibatisbasic.repository.GradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
*   Mybatis一对多映射
*/

@Service
public class GradeService {

    @Resource
    private GradeRepository gradeRepository;

    public List<Grade> findAll(){
        return gradeRepository.findAll();
    }
}
