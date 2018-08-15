package com.cn.connext.project.basic.repository.relationJPA.OneToOneRepository;

import com.cn.connext.project.basic.entity.relationJPA.OneToOne.Student;
import com.cn.connext.project.framework.repository.ConnextRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ConnextRepository<Student, String>, JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {
    @Query(value = "select * from student s where s.name=?1", nativeQuery = true)
    Student findStudent(@Param("name")String name);
}
