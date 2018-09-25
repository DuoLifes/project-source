package com.cn.connext.project.technologys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "jpaAuditorAware")//使用mongo，也可以使用其他，如jpa（mysql）
public class JpaAuditorAware implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        return "System";
    }
}