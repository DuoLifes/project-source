package com.cn.connext.project.portal.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PortalDataSourceQueue {
    String PROJECT_PORTALDATA_SEND = "PROJECT_PortalData_Send";
    String PROJECT_PORTALDATA_RECV = "PROJECT_PortalData_Recv";

    @Output(PROJECT_PORTALDATA_SEND)
    MessageChannel portalData_send_channel();

    @Input(PROJECT_PORTALDATA_RECV)
    SubscribableChannel portalData_recv_channel();
}
