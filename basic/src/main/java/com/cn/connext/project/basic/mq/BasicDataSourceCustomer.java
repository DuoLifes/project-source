package com.cn.connext.project.basic.mq;

import com.cn.connext.project.basic.entity.Media;
import com.cn.connext.project.framework.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding({BasicDataSourceQueue.class})
public class BasicDataSourceCustomer {
    private static final Logger logger = LoggerFactory.getLogger(BasicDataSourceCustomer.class);

    @StreamListener(BasicDataSourceQueue.PROJECT_BASICDATA_RECV)
    public void receiver(@Payload String message) {
        logger.info("receive message:" + message);
        try{
            Media media = JSON.parseObject(message, Media.class);
        }catch (Exception e){
            logger.info(e.toString());
        }
    }
}
