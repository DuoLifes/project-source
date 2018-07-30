package com.cn.connext.project.framework.annotation;

import com.cn.connext.project.framework.mongodbrepository.ConnextMongoRepositoryImpl;
import com.cn.connext.project.framework.repository.ConnextJpaRepository;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableCaching
@SpringBootConfiguration
@EnableAutoConfiguration()
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.cn.connext"})
@EnableJpaRepositories(repositoryBaseClass = ConnextJpaRepository.class)
@EnableMongoRepositories(repositoryBaseClass = ConnextMongoRepositoryImpl.class)
@ComponentScan(
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {TypeExcludeFilter.class}
        ), @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {AutoConfigurationExcludeFilter.class}
        )}
)
public @interface ConnextMicroServiceApplication {
    @AliasFor(
            annotation = EnableAutoConfiguration.class,
            attribute = "exclude"
    )
    Class<?>[] exclude() default {};

    @AliasFor(
            annotation = EnableAutoConfiguration.class,
            attribute = "excludeName"
    )
    String[] excludeName() default {};

    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackages"
    )
    String[] scanBasePackages() default {"com.cn.connext"};

    @AliasFor(
            annotation = ComponentScan.class,
            attribute = "basePackageClasses"
    )
    Class<?>[] scanBasePackageClasses() default {};
}
