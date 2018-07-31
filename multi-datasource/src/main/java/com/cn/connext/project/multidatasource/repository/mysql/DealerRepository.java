package com.cn.connext.project.multidatasource.repository.mysql;

import com.cn.connext.project.framework.repository.ConnextRepository;
import com.cn.connext.project.multidatasource.entity.mysql.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * 经销商信息 - 数据访问接口定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Repository
public interface DealerRepository extends ConnextRepository<Dealer, String>, JpaRepository<Dealer, String>, JpaSpecificationExecutor<Dealer> {

    @Transactional
    @Modifying
    @Query(value = "TRUNCATE TABLE `dealer`", nativeQuery = true)
    void clear();

}

