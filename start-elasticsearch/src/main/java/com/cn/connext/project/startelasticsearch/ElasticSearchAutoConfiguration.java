package com.cn.connext.project.startelasticsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchAutoConfiguration {
    @Bean
    public ElasticSearchBase elasticSearchBase() {
        return new ElasticSearchBase();
    }
}
