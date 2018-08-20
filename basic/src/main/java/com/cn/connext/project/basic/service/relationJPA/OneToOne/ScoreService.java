package com.cn.connext.project.basic.service.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
import com.cn.connext.project.basic.repository.relationJPA.OneToOne.ScoreRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ScoreService {
    @Resource
    private ScoreRepository scoreRepository;

    //增加/修改
    public Score save(Score score){
        return scoreRepository.save(score);
    }

    //验证级联删除
    public void delete(Long id){
        scoreRepository.deleteById(id);
    }

    //查询
    public Score findById(Long id){
        return scoreRepository.findById(id);
    }
}
