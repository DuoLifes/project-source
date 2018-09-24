package com.cn.connext.project.technologys.repository;

import com.cn.connext.project.technologys.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 媒体信息 - 数据访问接口定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Repository
public interface MediaRepository extends JpaRepository<Media, String>, JpaSpecificationExecutor<Media> {

    //jpa封装方法直接调用
    List<Media> findAllByCodeAndName(String code, String name);

    //自定义SQL
    @Query(value = "select * from media m where m.code like concat(:code,'%') and m.code!=:code", nativeQuery = true)
    List<Media> findAllByCode(@Param("code") String code);
}

