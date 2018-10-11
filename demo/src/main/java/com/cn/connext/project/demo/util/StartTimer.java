//package com.cn.connext.project.demo.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import static java.util.concurrent.Executors.newScheduledThreadPool;
//
///**
// * @author : 张帅
// * @package com.cn.connext.project.demo.domain：
// * @time : 2018/10/10 16:14
// * 启动定时任务
// */
//@Component
//public class StartTimer implements CommandLineRunner {
//
//    private static final Logger logger = LoggerFactory.getLogger(StartTimer.class);
//
//    /**
//     * 定时器的循环执行时间
//     */
//    private Integer period=2000;
//
//    @Override
//    public void run(String... strings) throws Exception {
//        ScheduledExecutorService executor = newScheduledThreadPool(1);
//        executor.scheduleAtFixedRate(
//                () -> {
//                    try {
//                        logger.info("开始任务！");
//                      } catch (Exception e) {
//                        logger.error("定时任务发生错误:"+e);
//                    }
//                },
//                0,//运行前延迟时间
//                period,//两次执行的时间间隔
//                TimeUnit.MILLISECONDS);//时间单位
//    }
//
//    public static void main(String[] args) {
//        StartTimer startTimer=new StartTimer();
//        try {
//            startTimer.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
