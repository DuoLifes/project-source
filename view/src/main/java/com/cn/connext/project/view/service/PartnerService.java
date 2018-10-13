package com.cn.connext.project.view.service;

import com.cn.connext.project.view.entity.Partner;
import com.cn.connext.project.view.repository.PartnerRepository;
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
     * 创建新的合作伙伴信息。
     * @param partner 所要创建的合作伙伴信息对象实例
     * @return 返回所创建的对象实例
     */
    public Partner create(Partner partner) {
        return partnerRepository.save(partner);
    }

    /**
     * 修改已有合作伙伴信息。
     * @param partner 所要修改的合作伙伴信息对象实例
     * @return 返回修改后对象实例
     */
    public Partner modify(Partner partner) {
        return partnerRepository.save(partner);
    }

    /**
     * 根据主键删除媒体信息。
     * @param id 主键 - 唯一编号
     */
    public void delete(String id) {
        partnerRepository.delete(id);
    }

    /**
     * 根据主键查找合作伙伴信息。
     * @param id 主键 - 唯一编号
     * @return 返回所匹配的合作伙伴信息对象实例
     */
    public Partner findItem(String id) {
        return partnerRepository.findOne(id);
    }

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    public List<Partner> findList() {
        return partnerRepository.findAll();
    }


}