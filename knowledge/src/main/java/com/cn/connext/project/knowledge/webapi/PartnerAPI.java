package com.cn.connext.project.knowledge.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.knowledge.entity.Media;
import com.cn.connext.project.knowledge.entity.Partner;
import com.cn.connext.project.knowledge.service.MediaService;
import com.cn.connext.project.knowledge.service.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

/**
 * 合作伙伴信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/knoledge/partner")
public class PartnerAPI {

    /**
     * 合作伙伴信息 - 业务服务对象
     */
    @Resource
    private PartnerService partnerService;
    @Resource
    private MediaService mediaService;

    private static final Logger logger = LoggerFactory.getLogger(PartnerAPI.class);

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    @GetMapping("/list")
    public List<Partner> findList() {
        return partnerService.findList();
    }

    /*事务管理*/
    @GetMapping("/create")
    @Transactional(value = "",isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public String addPartnerAndMedia(){
        try {
            Media media=new Media();
            Partner partner=new Partner();
            partner.setId(null);
            mediaService.create(media);
            partnerService.create(partner);
        } catch (Exception e) {
            logger.info("增加事务异常："+e);
        }
        return "success";
    }
}

