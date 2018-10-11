package com.cn.connext.project.demo.common;

import com.cn.connext.project.demo.entity.Channel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*通过配置文件配置属性值*/
@Component
@ConfigurationProperties(prefix = "project.config")
public class PropertyConfig {

    private List<String> media;

    private List<Channel> channel;

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public void setChannel(List<Channel> channel) {
        this.channel = channel;
    }
}
