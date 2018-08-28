package com.cn.connext.project.portal.kafka;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Slf4j
@WebAPI("/api/portal/kafka")
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    @GetMapping
    public void send() {
        String message="KafkaMessage";
        kafkaTemplate.send("test",message);
    }
}