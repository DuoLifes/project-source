package com.cn.connext.project.qrcode.cache;

import com.alibaba.fastjson.JSONObject;
import com.cn.connext.project.qrcode.qrcodeUtil.WeixinUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenCache {

    @Resource
    private WeixinUtil weixinUtil;

    @Cacheable(value = "ddmp.qrcode.qrcode.getToken",key = "#appId")
    public synchronized Map<String, Object> getToken(String appId,String appSecret) {
        Map<String,Object> resMap = new HashMap<>();
        Long time = new Date().getTime();
        resMap.put("time",time);
        resMap.put("appId",appId);
        resMap.put("appSecret",appSecret);
        JSONObject jsonObject = weixinUtil.getAccessToken(appId,appSecret);
        if(jsonObject.getString("access_token")==null){
            resMap.put("code",jsonObject.get("errcode"));
            resMap.put("token","");
        } else {
            resMap.put("code","10001");
            resMap.put("token",jsonObject.getString("access_token"));
        }
        return resMap;
    }
    @CacheEvict(value = {"ddmp.qrcode.qrcode.getToken"},key = "#appId")
    public synchronized void clear(String appId) {

    }
}
