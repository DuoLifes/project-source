package com.cn.connext.project.basic.cache;

import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.basic.service.MediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component
public class MediaCache {

    private Logger logger = LoggerFactory.getLogger(MediaCache.class);

    @Resource
    private MediaService mediaService;

    @Cacheable("project.basic.cache.mediaCache")
    public List<Media> getMediaList() {
        logger.info("首次加载缓存！！！");
        return mediaService.findList();
    }

    @CacheEvict({"project.basic.cache.mediaCache"})
    public synchronized void clear() {
        logger.info("Media cache will be clear.");
    }
}
