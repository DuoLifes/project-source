package com.cn.connext.project.technology.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@ComponentScan("com.cn.connext.project.technology")
public class DataSourceConfig {
    @Value("${project-source.technology.mysql.driverClassName}")
    private String driverClassName;

    @Value("${project-source.technology.mysql.driverUrl}")
    private String driverUrl;

    @Value("${project-source.technology.mysql.driverUsername}")
    private String driverUsername;

    @Value("${project-source.technology.mysql.driverPassword}")
    private String driverPassword;

    @Bean(name = "dataSource")
    public  Connection dataSource() {
        try {
            Class.forName(driverClassName);
            //创建连接池
            DataSourceBuilder.create().build();
            return DriverManager.getConnection(driverUrl,driverUsername,driverPassword);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
