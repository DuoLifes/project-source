package com.cn.connext.project.basic.cache;

import com.cn.connext.project.common.constant.CacheConstant;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 管理所有缓存清除
 */
@Component
public class GlobalCacheManager {

    @Resource
   private MediaCache mediaCache;

    public void clearCache(String cacheTypeName) {
        switch (cacheTypeName) {
            case CacheConstant.Media:
                mediaCache.clear();
                break;
        }
    }
}
