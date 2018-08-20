package com.cn.connext.project.ibatisbasic.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.ibatisbasic.entity.Teacher;
import com.cn.connext.project.ibatisbasic.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

/*
*   Mybatis多对一映射
*/

@WebAPI("/api/ibatis-basic/teacher")
public class TeacherAPI {

    @Resource
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }
}
