package com.cn.connext.project.startelasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

@Component
public class ElasticSearchConfig {
    @Autowired
    private ElasticSearchConfigurationProperties properties;

    @Bean
    public TransportClient client() {
        TransportClient client = new PreBuiltTransportClient(settings());
        client.addTransportAddress(transportAddress());
        return client;
    }

    private Settings settings() {
        return Settings.builder().put("cluster.name", properties.getCluster_name()) //设置ES实例的名称my-application
                //.put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
    }

    private TransportAddress transportAddress() {
        String[] host = properties.getCluster_nodes().split(":");
        Integer port = Integer.parseInt(host[1]);
        try {
            InetAddress address = InetAddress.getByName(host[0]);//106.75.119.31 getByName("192.168.56.102");
            InetSocketAddress ip = new InetSocketAddress(address, port);
            return new InetSocketTransportAddress(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
