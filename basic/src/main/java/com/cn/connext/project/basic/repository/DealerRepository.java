package com.cn.connext.project.basic.repository;

import com.cn.connext.project.basic.entity.Dealer;
import java.util.List;

/**
 * 经销商信息 - 数据访问接口定义
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */

public interface DealerRepository {
    List<Dealer> findAll();
}

