package com.cn.connext.project.multidatasource.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding({MultiDataSourceQueue.class})
public class BasicDataUpdateSubscriber {
    private static final Logger logger = LoggerFactory.getLogger(BasicDataUpdateSubscriber.class);

    @StreamListener(MultiDataSourceQueue.PROJECT_MULTI_DATASOURCE_RECV)
    public void receiver(@Payload String message) {
        try{
            logger.info("receive message:" + message);
        }catch (Exception e){
            logger.info(e.toString());
        }
    }
}
