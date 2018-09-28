package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.demo.entity.Coffee;
import com.cn.connext.project.demo.entity.Drink;
import com.cn.connext.project.demo.entity.Tea;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebAPI("api/demo/example")
public class ExampleAPI {

    private static final Logger logger = LoggerFactory.getLogger(ExampleAPI.class);

    /*多态实现*/
//    public static void main(String[] args) {
//        Tea tea=new Tea();
//        tea.drinkTea();
//        tea.drink();
//        tea.drink(1);
//        Drink drink=new Tea();
//        drink.drink();
//        Drink drink1=new Coffee();
//        drink1.drink();
//    }

    public static void main(String[] args) {
//        String a="zbcdefg";
//        System.out.println(a.length());

//        String [] test={"abc","efg","hij"};
//        System.out.println(test.length);

        String demo="test1";
        demo="test2";
        StringBuffer demo2=new StringBuffer("sss");
        demo2.indexOf("ccc");
        System.out.println(demo2);
    }
}
