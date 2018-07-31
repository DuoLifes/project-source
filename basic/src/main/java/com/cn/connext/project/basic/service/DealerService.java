package com.cn.connext.project.basic.service;

import com.cn.connext.project.basic.entity.Dealer;
import com.cn.connext.project.basic.repository.DealerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 经销商信息 - 业务服务对象
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Service
public class DealerService {

    /**
     * 系统日志
     */
    private final static Logger logger = LoggerFactory.getLogger(DealerService.class);


    @Resource
    private DealerRepository dealerRepository;

    public List<Dealer> findAll(){
        return dealerRepository.findAll();
    }
}

