package com.cn.connext.project.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class GlobalDataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}