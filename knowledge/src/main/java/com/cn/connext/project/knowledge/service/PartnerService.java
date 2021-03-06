package com.cn.connext.project.knowledge.service;

import com.cn.connext.project.knowledge.entity.Partner;
import com.cn.connext.project.knowledge.repository.PartnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 合作伙伴信息 - 业务服务对象
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@Service
public class PartnerService {

    /**
     * 系统日志
     */
    private final static Logger logger = LoggerFactory.getLogger(PartnerService.class);


    /**
     * 合作伙伴信息 - 数据访问接口
     */
    @Resource
    private PartnerRepository partnerRepository;

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    public List<Partner> findList() {
        return partnerRepository.findAll();
    }

    public Partner create(Partner partner){
        return partnerRepository.save(partner);
    }


}