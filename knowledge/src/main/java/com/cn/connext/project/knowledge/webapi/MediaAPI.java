package com.cn.connext.project.knowledge.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.knowledge.entity.Media;
import com.cn.connext.project.knowledge.service.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

/**
 * 媒体信息 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/knoledge/media")
public class MediaAPI {

    /**
     * 媒体信息 - 业务服务对象
     */
    @Resource
    private MediaService mediaService;

    private static final Logger logger = LoggerFactory.getLogger(MediaAPI.class);

    /**
     * 根据查询构造器，查询所有匹配的记录。
     * @return 返回数据集合信息
     */
    @GetMapping("/list")
    public List<Media> findList() {
        return mediaService.findList();
    }
}

