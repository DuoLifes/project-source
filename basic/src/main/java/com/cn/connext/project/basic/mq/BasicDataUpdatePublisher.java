package com.cn.connext.project.basic.mq;

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
@EnableBinding({BasicDataUpdateSource.class})
public class BasicDataUpdatePublisher {

    Logger logger = LoggerFactory.getLogger(BasicDataUpdatePublisher.class);

    @Resource
    @Qualifier(BasicDataUpdateSource.PROJECT_BASICDATA_SEND)
    private MessageChannel basicData_update_send_channel;

    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).build();
        logger.info("send message:"+msg);
        basicData_update_send_channel.send(message);

    }
}
