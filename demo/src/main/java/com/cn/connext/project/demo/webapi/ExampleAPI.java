package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

//    public static void main(String[] args) {
//        String a="zbcdefg";
//        System.out.println(a.length());
//
//        String [] test={"abc","efg","hij"};
//        System.out.println(test.length);
//
//        String demo="test1";
//        demo="test2";
//        StringBuffer demo2=new StringBuffer("abcdefg");
//        demo2.indexOf("cd");
//        System.out.println(demo2.indexOf("cd"));
//        List<Tea>list=new ArrayList<>();
//        Map<String,Object> map=new HashMap<>();
//        Hashtable<String,Tea> hashtable=new Hashtable<>();
//        Integer cc=2;
//        int b=4;
//        Object object1=b;
//        Object object=a;
//        byte aa=11;
//        System.out.println("aa=="+aa);
//    }

        /*判断*/
//    public static void main(String[] args) {
//        String a="b";
//        String test="a".equals(a)?test="yes":"no";
//        System.out.println(test);
//    }


    /*正则表达式验证字符串*/
//    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("^[a-zA-Z]\\w{5,17}$");
//        String test="abcdef";
//        Matcher matcher = pattern.matcher(test);
//        System.out.println(matcher.find());
//        try {
//            String aa=matcher.group();
//            System.out.println("aa=="+aa);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        //圆周率
        //System.out.println(Math.PI);
        //计算当前时间的半小时前
        SimpleDateFormat sfm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -30);
        String date = sfm1.format(calendar.getTime());
        System.out.println(date);
    }

}
