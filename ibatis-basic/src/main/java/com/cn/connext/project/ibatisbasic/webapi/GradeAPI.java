package com.cn.connext.project.ibatisbasic.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.ibatisbasic.entity.Grade;
import com.cn.connext.project.ibatisbasic.service.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

/*
*   Mybatis一对多映射
*/

@WebAPI("/api/ibatis-basic/grade")
public class GradeAPI {

    @Resource
    private GradeService gradeService;

    @GetMapping("/findAll")
    public List<Grade> findAll(){
        return gradeService.findAll();
    }
}
