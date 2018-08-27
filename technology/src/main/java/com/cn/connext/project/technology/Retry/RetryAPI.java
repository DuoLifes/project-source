package com.cn.connext.project.technology.Retry;

import com.cn.connext.project.framework.annotation.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAPI("/api/technology/retry")
public class RetryAPI {

    private static final Logger logger = LoggerFactory.getLogger(RetryAPI.class);

    @Autowired
    private RetryService retryService;

    @GetMapping
    public String login() throws Exception {
        retryService.call();
        return String.valueOf("重试方法结束！");
    }
}