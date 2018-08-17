package com.cn.connext.project.basic.webapi.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
import com.cn.connext.project.basic.service.relationJPA.OneToOne.ScoreService;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;

@WebAPI("/api/basic/oneToOne/score")
public class ScoretAPI {
    @Resource
    private ScoreService scoreService;

    @GetMapping("/findById")
    public Score findById(@RequestParam Long id){
        return scoreService.findById(id);
    }
}
