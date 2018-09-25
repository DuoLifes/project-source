package com.cn.connext.project.technologys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*该配置类获取用户名称，为创建实体时被@createBy注解标记的字段添加创建人*/
@Configuration
@EnableJpaAuditing(auditorAwareRef = "jpaAuditorAware")//使用mongo，也可以使用其他，如jpa（mysql）
public class JpaAuditorAware implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        return "System";
    }
}