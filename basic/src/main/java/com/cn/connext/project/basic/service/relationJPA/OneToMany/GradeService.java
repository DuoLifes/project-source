package com.cn.connext.project.basic.service.relationJPA.OneToMany;

import com.cn.connext.project.basic.entity.relationJPA.OneToMany.Grade;
import com.cn.connext.project.basic.repository.relationJPA.OneToMany.GradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class GradeService {
    @Resource
    private GradeRepository gradeRepository;

    //增加/修改
    public Grade save(Grade grade){
        return gradeRepository.save(grade);
    }

    //验证级联删除
    public void delete(String name){
         gradeRepository.deleteByName(name);
    }

    //查询
    public Grade findByName(String name){
        return gradeRepository.findByName(name);
    }

}
