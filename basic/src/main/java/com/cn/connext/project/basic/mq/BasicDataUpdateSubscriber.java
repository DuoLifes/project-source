package com.cn.connext.project.basic.mq;

import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.framework.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding({BasicDataUpdateSource.class})
public class BasicDataUpdateSubscriber {
    private static final Logger logger = LoggerFactory.getLogger(BasicDataUpdateSubscriber.class);

    @StreamListener(BasicDataUpdateSource.PROJECT_BASICDATA_RECV)
    public void receiver(@Payload String message) {
        logger.info("receive message:" + message);
        try{
            Media media = JSON.parseObject(message, Media.class);
            logger.info(JSON.toJsonString(media).toString());
        }catch (Exception e){
            logger.info(e.toString());
        }
    }
}
