package com.cn.connext.project.basic.webapi.relationJPA.OneToMany;

import com.cn.connext.project.basic.entity.relationJPA.OneToMany.Teacher;
import com.cn.connext.project.basic.service.relationJPA.OneToMany.TeacherService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@WebAPI("/api/basic/oneToMany/teacher")
public class TeacherAPI {
    @Resource
    private TeacherService teacherService;

    /*  teacher作为维护端可以增加自己也可以增加被维护端的grade，
    *   如果grade已经被创建则不会重新创建，其中grade值不变，
    *   则只增加teacher，grade值改变则执行修改grade和增加teacher
    *   若grade没有被创建，则先创建grade再创建teacher.
    */
    //增加
    @PostMapping("/create")
    public Teacher create(@RequestBody Teacher teacher){
        return teacherService.create(teacher);
    }

    //删除
    @DeleteMapping("/delete")
    public void delete(@RequestParam String name){
        teacherService.delete(name);
    }

    //修改
    @PutMapping("/update")
    public Teacher update(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    //查询
   @GetMapping("/findByName")
    public Teacher findByName(@RequestParam String name){
        return teacherService.findByName(name);
   }
}
