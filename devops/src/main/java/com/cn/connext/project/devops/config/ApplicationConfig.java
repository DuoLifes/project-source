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

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/api/devops/**");
//    }

    //对无业务逻辑的页面跳转操作作统一管理
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/devops").setViewName("forward:/index.htm");//默认读取static包下的静态资源，如果再加一层包路径如下。例如:"forward:/view/index.htm"
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Resources without Spring Security. No cache control response headers.
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.noCache());//http缓存

        staticResourceFolderList.forEach(folderName -> {
            registry.addResourceHandler("/" + folderName + "/**")
                    .addResourceLocations("classpath:/static/" + folderName + "/")
                    .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS).cachePublic());
        });
    }

}
