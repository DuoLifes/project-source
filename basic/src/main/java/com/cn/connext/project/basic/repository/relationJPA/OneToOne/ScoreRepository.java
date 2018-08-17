package com.cn.connext.project.basic.repository.relationJPA.OneToOne;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Score;
import com.cn.connext.project.framework.repository.ConnextRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends ConnextRepository<Score, String>, JpaRepository<Score, String>, JpaSpecificationExecutor<Score> {
    Score findById(Long id);
}
