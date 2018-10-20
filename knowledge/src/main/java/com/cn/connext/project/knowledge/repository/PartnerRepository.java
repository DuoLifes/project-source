package com.cn.connext.project.knowledge.repository;

import com.cn.connext.project.knowledge.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 媒体信息 - 数据访问接口定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner, String>, JpaSpecificationExecutor<Partner> {

}

