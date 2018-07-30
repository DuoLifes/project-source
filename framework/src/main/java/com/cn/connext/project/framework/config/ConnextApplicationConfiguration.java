package com.cn.connext.project.framework.config;

import com.cn.connext.project.framework.repository.ConnextJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = ConnextJpaRepository.class)
public class ConnextApplicationConfiguration {

}
