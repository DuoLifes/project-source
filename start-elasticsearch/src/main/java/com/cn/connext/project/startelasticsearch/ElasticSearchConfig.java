package com.cn.connext.project.startelasticsearch;

import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.text.MessageFormat;

@Configuration
@ConditionalOnClass({Client.class, TransportClient.class})
@ConditionalOnProperty(prefix = "es", name = "enabled", havingValue = "true", matchIfMissing = true)
public class ElasticSearchConfig implements DisposableBean {
    private final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);
    private final TransportClient transportClient;

    public ElasticSearchConfig(ElasticSearchConfigurationProperties properties) {
        long beginTime = System.currentTimeMillis();

        transportClient = new PreBuiltTransportClient(Settings.builder().put("cluster.name", properties.getCluster_name()).build());
        properties.getTransportAddresses().forEach(transportClient::addTransportAddress);

        logger.info(MessageFormat.format(
                "Started initialize ElasticSearch cluster client in {0}ms, nodes count: {1}",
                System.currentTimeMillis() - beginTime,
                transportClient.connectedNodes().size()));
    }

    @Bean
    public TransportClient getTransportClient() {
        return this.transportClient;
    }


    @Override
    public void destroy() throws Exception {
        logger.info("Closing ElasticSearch cluster client");
        transportClient.close();
    }

}
