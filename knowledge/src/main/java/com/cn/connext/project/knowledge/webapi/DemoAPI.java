package com.cn.connext.project.knowledge.webapi;

import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.knowledge.annotation.ForumService;
import com.cn.connext.project.knowledge.annotation.NeedTest;
import com.cn.connext.project.knowledge.entity.Media;
import com.cn.connext.project.knowledge.enums.Sex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DemoAPI {

    private static final Logger logger = LoggerFactory.getLogger(DemoAPI.class);

    /*测试枚举*/
    /*public static void main(String[] args) {
        System.out.println("枚举值:"+ Sex.man.getValue());
    }*/


    /*截取字符串*/
    /*public static void main(String[] args) {
        String str="This,Server,Is,Knowledge!";
        String[] test = str.split(",");
        for (int i=0;i<test.length;i++) {
            System.out.println("第"+(i+1)+"个元素是:"+test[i]);
        }
    }*/


    /*打印map*/
    /*public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("time",new Date());
        map.put("age",25);
        logger.info("map:"+map.toString());
    }*/


    /*重写toString方法打印实体*/
	/*toJsonString方法打印实体*/
    /*public static void main(String[] args) {
        Media media=new Media();
        logger.info("media:"+ JSON.toJsonString(media));
        logger.info("media:"+ media.toString());
    }*/


    /*自定义注解验证*/
    /*public static void main(String[] args) {
        //获取类
        Class clazz= ForumService.class;
        //获取类中的方法
        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods){
            //获取方法上的注解
            NeedTest nt=method.getAnnotation(NeedTest.class);
            if(nt!=null){
                if(nt.value()){
                    System.out.println("需要测试");
                }
                else {
                    System.out.println("不需要测试");
                }
            }
        }
    }*/


    /*跟进下标取字符串值*/
    /*public static void main(String[] args) {
        String str="abcdefg";
        logger.info("str=="+str.charAt(2));
    }*/
}
