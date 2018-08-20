package com.cn.connext.project.ibatisbasic.repository;

import com.cn.connext.project.ibatisbasic.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
*   Mybatis一对多映射
*/

@Mapper
public interface GradeRepository {

    List<Grade> findAll();
}
