package com.cn.connext.project.ibatisbasic.repository;

import com.cn.connext.project.ibatisbasic.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/*
*   Mybatis多对一映射
*/
@Mapper
public interface TeacherRepository {

    List<Teacher> findAll();
}
