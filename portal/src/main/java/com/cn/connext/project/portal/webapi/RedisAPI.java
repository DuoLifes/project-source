package com.cn.connext.project.portal.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@WebAPI("/api/portal/redis")
public class RedisAPI {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/create")
    public void create(){
        redisTemplate.opsForValue().set("003", "陈奕迅");
        redisTemplate.opsForValue().set("004", "张学友");
    }
}
