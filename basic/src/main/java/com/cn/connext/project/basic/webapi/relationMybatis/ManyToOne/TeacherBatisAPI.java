package com.cn.connext.project.basic.webapi.relationMybatis.ManyToOne;

import com.cn.connext.project.basic.entity.relationMybatis.ManyToOne.Teacher;
import com.cn.connext.project.basic.service.relationMybatis.ManyToOne.TeacherBatisService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/basic/mybatis/manyToOne/teacher")
public class TeacherBatisAPI {

    @Resource
    private TeacherBatisService teacherBatisService;

    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherBatisService.findAll();
    }
}
