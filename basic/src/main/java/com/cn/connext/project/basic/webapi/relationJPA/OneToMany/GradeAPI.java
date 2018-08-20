package com.cn.connext.project.basic.webapi.relationJPA.OneToMany;

import com.cn.connext.project.basic.entity.relationJPA.OneToMany.Grade;
import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.service.relationJPA.OneToMany.GradeService;
import com.cn.connext.project.basic.service.relationJPA.OneToOne.StudentService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@WebAPI("/api/basic/oneToMany/grade")
public class GradeAPI {
    @Resource
    private GradeService gradeService;

    //增加/修改  (由于Grade是被维护端所以无法增加修改维护端的数据，只能增加修改Grade本身)
    @PostMapping("/save")
    public Grade save(@RequestBody Grade grade){
        return gradeService.save(grade);
    }

    //验证级联删除
    @GetMapping("/delete")
    public void delete(String name){
        gradeService.delete(name);
    }

    //查询
   @GetMapping("/findByName")
    public Grade findByName(@RequestParam String name){
        return gradeService.findByName(name);
   }

}
