package com.cn.connext.project.basic.webapi.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
import com.cn.connext.project.basic.service.relationJPA.OneToOne.ScoreService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@WebAPI("/api/basic/oneToOne/score")
public class ScoretAPI {
    @Resource
    private ScoreService scoreService;

    //验证级联增加
    /*      从字表方向向主表方向的增加逻辑有误，无法实现，主表外键列为空
            @PostMapping("/create")
            public Score create(@RequestBody Score score){
                return scoreService.create(score);
                }
    */

    //验证级联修改
    @PutMapping("/update")
    /*
    * 修改参数为:{"id": 2,"chinese": 77, "math": 88} 不能带主表参数，否则主表外键则无法修改被置空
    */
    public void update(@RequestBody Score score){
        scoreService.update(score);
    }

    //验证级联删除
    @GetMapping("/delete")
    public void delete(@RequestParam Long id){
        scoreService.delete(id);
    }

    //查询
    @GetMapping("/findById")
    public Score findById(@RequestParam Long id){
        return scoreService.findById(id);
    }
}
