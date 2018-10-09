package com.cn.connext.project.demo.webapi;

import com.alibaba.fastjson.JSONObject;
import com.cn.connext.project.demo.entity.Coffee;
import com.cn.connext.project.demo.entity.Drink;
import com.cn.connext.project.demo.entity.Tea;
import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebAPI("api/demo/example")
public class ExampleAPI {

    private static final Logger logger = LoggerFactory.getLogger(ExampleAPI.class);

    /*多态实现*/
    /*public static void main(String[] args) {
        Tea tea=new Tea();
        tea.drinkTea();
        tea.drink();
        tea.drink(1);
        Drink drink=new Tea();
        drink.drink();
        Drink drink1=new Coffee();
        drink1.drink();
    }*/


    /*知识点验证*/
    /*public static void main(String[] args) {
        String a="zbcdefg";
        System.out.println(a.length());

        String [] test={"abc","efg","hij"};
        System.out.println(test.length);

        String demo="test1";
        demo="test2";
        StringBuffer demo2=new StringBuffer("abcdefg");
        demo2.indexOf("cd");
        System.out.println(demo2.indexOf("cd"));
        List<Tea> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        Hashtable<String,Tea> hashtable=new Hashtable<>();
        Integer cc=2;
        int b=4;
        Object object1=b;
        Object object=a;
        byte aa=11;
        System.out.println("aa=="+aa);
    }*/

    /*java判断方式*/
    /*public static void main(String[] args) {
        String a = "b";
        String test = "a".equals(a) ? test = "yes" : "no";
        System.out.println(test);
    }*/


    /*正则表达式验证字符串*/
    /*public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]\\w{5,17}$");
        String test = "abcdef";
        Matcher matcher = pattern.matcher(test);
        System.out.println(matcher.find());
        try {
            String aa = matcher.group();
            System.out.println("aa==" + aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /*Math的方法&&对时间的处理方式*/
    /*public static void main(String[] args) {
        //圆周率
        //System.out.println(Math.PI);
        //计算当前时间的半小时前
        SimpleDateFormat sfm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -30);
        String date = sfm1.format(calendar.getTime());
        System.out.println(date);
    }*/



    /*格式化字符串的作用*/
    /*public static void main(String[] args) {
        String result = MessageFormat.format("{0}''s Grade is A.", "abcdef");
        System.out.println(result);

        String a = "aaa";
        String b = "bb";
        String c = "c";
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b).append(c);
        System.out.println(MessageFormat.format(" {0} {1} {2} {3}", a, b, "", sb));
        System.out.println(MessageFormat.format(" ''{0}'' '{1}' {2} {3}", a, b, "", sb.toString()));
    }*/
}
