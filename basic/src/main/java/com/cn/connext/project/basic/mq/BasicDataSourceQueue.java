package com.cn.connext.project.basic.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BasicDataSourceQueue {
    String PROJECT_BASICDATA_SEND = "PROJECT_BasicData_Send";
    String PROJECT_BASICDATA_RECV = "PROJECT_BasicData_Recv";

    @Output(PROJECT_BASICDATA_SEND)
    MessageChannel basicData_send_channel();

    @Input(PROJECT_BASICDATA_RECV)
    SubscribableChannel basicData_recv_channel();
}
