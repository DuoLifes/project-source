package com.cn.connext.project.basic.service.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
import com.cn.connext.project.basic.repository.relationJPA.OneToOne.ScoreRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ScoreService {
    @Resource
    private ScoreRepository scoreRepository;

    //验证级联增加
    public Score create(Score score){
        return scoreRepository.create(score);
    }

    //验证级联删除
    public void delete(Long id){
        scoreRepository.deleteById(id);
    }

    //验证级联修改
    public void update(Score score){
        scoreRepository.save(score);
    }

    //查询
    public Score findById(Long id){
        return scoreRepository.findById(id);
    }
}
