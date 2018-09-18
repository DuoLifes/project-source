package com.cn.connext.project.technology.config;

import com.cn.connext.project.technology.entity.Asynchronous;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.text.ParseException;



/*定时任务*/
@Component
@Configurable
@EnableScheduling
public class ScheduledConfig{
    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(ScheduledConfig.class);
//    int i=1;
//    int j=1;
//
//    @Scheduled(cron="0/3 * *  * * ? ")  //3秒执行一次
//    public void Scheduled1 () throws ParseException {
//        logger.info("任务1执行第:"+i+"次");
//        i++;
//    }
//    @Scheduled(cron="0/2 * *  * * ? ")  //3秒执行一次
//    public void Scheduled2 () throws ParseException {
//        logger.info("任务2执行第:"+j+"次");
//        j++;
//    }

    @Resource
    private Asynchronous asynchronous;

    int k=1;
    @Scheduled(cron="0/100 * *  * * ? ")  //100秒执行一次
    public void Scheduled3 () throws ParseException {
        for(int i=1;i<=10;i++){
            asynchronous.test(i);
            logger.info("第"+k+"次定时任务"+"第"+i+"次执行完毕!");
        }
        k++;
    }
}
