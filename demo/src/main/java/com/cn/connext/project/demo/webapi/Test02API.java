package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.framework.Validator;
import com.netflix.discovery.util.StringUtil;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
*  main方法单元测试小知识点
*/

public class Test02API {

    /*字符串首字母转小写*/
    /*public static void main(String[] args) {
        String s="Abcde";
        if(Character.isLowerCase(s.charAt(0))) {
            System.out.println(s);
        } else {
            System.out.println((new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString());
        }
    }*/

    /*验证字段是否为空*/
    /*public static void main(String[] args) {
        String value="abcdefg";
        boolean flag= Validator.isEmpty(value);
        System.out.println("flag=="+flag);
    }*/


    /*Double类型保留有效数字*/
    /*public static void main(String[] args) {
        double a=2.445555;
        double b=5.897788;
        double c=a+b;
        *//*保留有效数字计算*//*
        double result=Math.round(c*100)/100d;
        System.out.println(c);
        System.out.println(result);
        *//*添加百分号*//*
        System.out.println(String.format("%.2f",result)+"%");
    }*/

    /*时间格式化:Date转String*/
    /*public static void main(String[] args) {
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        String date = format.format(time);
        System.out.println(date);
    }*/

    /*时间格式化:String转Date&&DateTime*/
    /*public static void main(String[] args) {
        try {
            String time="2018-10-20";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(time);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

    /*StringUtils.isEmpty判空*/
    /*public static void main(String[] args) {
        String a="";
        String b=null;
        boolean flag=false;
        if(StringUtils.isEmpty(a)){
            flag=true;
        }
        System.out.println(flag);
    }*/

}
