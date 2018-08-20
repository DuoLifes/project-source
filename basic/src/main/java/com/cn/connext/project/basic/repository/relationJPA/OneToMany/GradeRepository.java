package com.cn.connext.project.basic.repository.relationJPA.OneToMany;

import com.cn.connext.project.basic.entity.relationJPA.OneToMany.Grade;
import com.cn.connext.project.framework.repository.ConnextRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GradeRepository extends ConnextRepository<Grade, String>, JpaRepository<Grade, String>, JpaSpecificationExecutor<Grade> {

    Grade findByName(String name);

    @Transactional   //级联删除要通过此注解进行事务管理
    void deleteByName(String name);
}
