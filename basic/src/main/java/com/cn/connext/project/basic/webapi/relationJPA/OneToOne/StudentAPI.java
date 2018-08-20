package com.cn.connext.project.basic.webapi.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.basic.service.relationJPA.OneToOne.StudentService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@WebAPI("/api/basic/oneToOne/student")
public class StudentAPI {
    @Resource
    private StudentService studentService;

    /*  student作为维护端可以增加自己也可以增加被维护端的score，
    *   如果score已经被创建则不会重新创建，其中score值不变，
    *   则只增加student，score值改变则执行修改grade和增加teacher
    *   若score没有被创建，则先创建score再创建student.
    */
    //增加
    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    //验证级联修改
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }

    //验证级联删除
    @GetMapping("/delete")
    public void delete(@RequestParam String name){
        studentService.delete(name);
    }

    //查询
    @GetMapping("/findByName")
    public Student findStudent(@RequestParam String name){
        return studentService.findByName(name);
    }

}
