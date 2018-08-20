package com.cn.connext.project.basic.repository.relationJPA.OneToMany;

import com.cn.connext.project.basic.entity.relationJPA.OneToMany.Teacher;
import com.cn.connext.project.framework.repository.ConnextRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepository extends ConnextRepository<Teacher, String>, JpaRepository<Teacher, String>, JpaSpecificationExecutor<Teacher> {

        @Transactional//级联删除要通过此注解进行事务管理
        void deleteByName(String name);

        Teacher findByName(String name);
}
