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
@EnableBinding({BasicDataSourceQueue.class})
public class BasicDataSourceProductor {

    Logger logger = LoggerFactory.getLogger(BasicDataSourceProductor.class);

    @Resource
    @Qualifier(BasicDataSourceQueue.PROJECT_BASICDATA_SEND)
    private MessageChannel basicData_send_channel;

    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).build();
        logger.info("send message:"+msg);
        basicData_send_channel.send(message);

    }
}
