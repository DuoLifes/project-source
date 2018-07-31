package com.cn.connext.project.multidatasource.mq;

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
@EnableBinding({MultiDataSourceQueue.class})
public class MultiDataSourceProductor {

    Logger logger = LoggerFactory.getLogger(MultiDataSourceProductor.class);

    @Resource
    @Qualifier(MultiDataSourceQueue.PROJECT_MULTI_DATASOURCE_SEND)
    private MessageChannel multiDataSource_send_channel;

    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).build();
        logger.info("send message:"+msg);
        multiDataSource_send_channel.send(message);

    }
}
