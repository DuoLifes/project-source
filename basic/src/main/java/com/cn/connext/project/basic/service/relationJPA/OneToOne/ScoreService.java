package com.cn.connext.project.basic.service.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
import com.cn.connext.project.basic.repository.relationJPA.OneToOne.ScoreRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ScoreService {
    @Resource
    private ScoreRepository scoreRepository;

    public Score findById(Long id){
        return scoreRepository.findById(id);
    }
}
