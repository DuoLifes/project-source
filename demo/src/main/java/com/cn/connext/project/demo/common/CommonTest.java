package com.cn.connext.project.demo.common;

import com.cn.connext.project.demo.entity.Channel;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/demo/commonTest")
public class CommonTest {
    @Resource
    private PropertyConfig propertyConfig;

    @GetMapping("/getMedia")
    public List<String> getMedia(){
        List<String> mediaList=propertyConfig.getMedia();
        return mediaList;
    }

    @GetMapping("/getChannel")
    public List<Channel> getChannel(){
        List<Channel> channelList=propertyConfig.getChannel();
        return channelList;
    }
}
