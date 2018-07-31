package com.cn.connext.project.portal.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@EnableBinding({PortalDataSourceQueue.class})
public class PortalDataSourceProductor {

    Logger logger = LoggerFactory.getLogger(PortalDataSourceProductor.class);

    @Resource
    @Qualifier(PortalDataSourceQueue.PROJECT_PORTALDATA_SEND)
    private MessageChannel portalData_send_channel;

    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).build();
        logger.info("send message:"+msg);
        portalData_send_channel.send(message);

    }
}
