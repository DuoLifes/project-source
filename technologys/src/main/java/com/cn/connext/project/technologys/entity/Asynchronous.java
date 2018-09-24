package com.cn.connext.project.technologys.entity;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/*异步方法类
* 用于检验该方法处于异步执行的状态
* 注意:异步方法不能写在调用该方法的类中，否则Spring无法截获该方法调用
* */
@Component
public class Asynchronous {

    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(Asynchronous.class);
    @Async
    public void test(int i) {
        for (int n = 1; n <= 100; n++) {
            logger.info("第" + i + "次任务,第"+n+"次执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.info("异常" + e);
            }
        }
    }
}
