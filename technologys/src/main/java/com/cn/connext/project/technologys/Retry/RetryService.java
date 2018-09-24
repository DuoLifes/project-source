package com.cn.connext.project.technologys.Retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    private static final Logger logger = LoggerFactory.getLogger(RetryService.class);

    @Retryable(value= {Exception.class},maxAttempts = 2,backoff = @Backoff(delay = 2000l,multiplier = 2))
    public void call() throws Exception {
        logger.info("do something...");
        throw new Exception("RPC调用异常");
    }
    @Recover
    public void recover(Exception e) {
        logger.info(" 重试结束，进入Recover！ ");
    }
}