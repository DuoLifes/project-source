package com.cn.connext.project.portal.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding({PortalDataSourceQueue.class})
public class PortalDataSourceCustomer {
    private static final Logger logger = LoggerFactory.getLogger(PortalDataSourceCustomer.class);

    @StreamListener(PortalDataSourceQueue.PROJECT_PORTALDATA_RECV)
    public void receiver(@Payload String message) {
        try{
            logger.info("receive message:" + message);
        }catch (Exception e){
            logger.info(e.toString());
        }
    }
}
