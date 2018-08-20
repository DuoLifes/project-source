package com.cn.connext.project.basic.repository.relationMybatis.ManyToOne;

import com.cn.connext.project.basic.entity.relationMybatis.ManyToOne.Teacher;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeacherBatisRepository {

    List<Teacher> findAll();
}
