package com.cn.connext.project.demo.repository;

import com.cn.connext.project.demo.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 媒体信息 - 数据访问接口定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Repository
public interface MediaRepository extends JpaRepository<Media, String>, JpaSpecificationExecutor<Media> {

}

