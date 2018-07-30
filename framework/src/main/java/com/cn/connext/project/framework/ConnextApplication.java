package com.cn.connext.project.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ConnextApplication {
    public static ConfigurableApplicationContext run(Object source, String... args) {
        return run(new Object[]{ConnextApplication.class, source}, args);
    }

    public static ConfigurableApplicationContext run(Object[] sources, String[] args) {
        SpringApplication springApplication = new SpringApplication(sources);
        return springApplication.run(args);
    }
}
