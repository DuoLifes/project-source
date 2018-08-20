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

    //增加/修改 (由于Score是被维护端所以无法增加修改维护端的数据，只能增加修改Score本身)
    @PostMapping("/save")
    public void save(@RequestBody Score score){
        scoreService.save(score);
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
