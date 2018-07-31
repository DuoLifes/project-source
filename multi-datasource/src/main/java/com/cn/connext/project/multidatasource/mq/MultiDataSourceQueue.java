package com.cn.connext.project.multidatasource.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MultiDataSourceQueue {
    String PROJECT_MULTI_DATASOURCE_SEND = "PROJECT_Multi-DataSource_Send";
    String PROJECT_MULTI_DATASOURCE_RECV = "PROJECT_Multi-DataSource_Recv";

    @Output(PROJECT_MULTI_DATASOURCE_SEND)
    MessageChannel multiDataSource_send_channel();

    @Input(PROJECT_MULTI_DATASOURCE_RECV)
    SubscribableChannel multiDataSource_recv_channel();
}
