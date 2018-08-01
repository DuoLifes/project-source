package com.cn.connext.project.devops.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    private final static List<String> staticResourceFolderList = Lists.newArrayList();

    static {
        staticResourceFolderList.add("js");
        staticResourceFolderList.add("img");
        staticResourceFolderList.add("css");
        staticResourceFolderList.add("views");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login.htm");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Resources without Spring Security. No cache control response headers.
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.noCache());

        staticResourceFolderList.forEach(folderName -> {
            registry.addResourceHandler("/" + folderName + "/**")
                    .addResourceLocations("classpath:/static/" + folderName + "/")
                    .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS).cachePublic());
        });
    }

}
