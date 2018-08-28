package com.cn.connext.project.technology.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.technology.config.KafkaConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@WebAPI("/api/technology/kafka")
public class KafkaAPI {

    @Resource
    private KafkaConfig kafkaConfig;

    /**
     * 向kafka发送线索
     *
     * @param topicName
     * @param message
     */
    @GetMapping("/send")
    public void sendmessage(@RequestParam String topicName, @RequestParam String message) {
        KafkaTemplate<String, String> kafkaTemplate = kafkaConfig.kafkaTemplate();
        kafkaTemplate.send(topicName, message);
    }
}
