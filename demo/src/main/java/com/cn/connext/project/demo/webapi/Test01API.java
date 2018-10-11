package com.cn.connext.project.demo.webapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*  main方法单元测试小知识点
*/

public class Test01API {

    private static final Logger logger = LoggerFactory.getLogger(Test01API.class);

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

    /*正则表达式验证时间格式**时间格式验证只支持"yyyy-MM-dd HH:mm:ss"与"yyyy-MM-dd HH:mm:ss.SSS*/
    /*public static void main(String[] args) {
        String regex = "^(\\d{4}\\-\\d{2}-\\d{2}\\s{1}\\d{2}:\\d{2}:\\d{2})(|\\.\\d{3})$";
        Pattern pattern = Pattern.compile(regex);
        String time="2018-10-10 12:00:00";
        Matcher matcher = pattern.matcher(time);
        boolean flag=matcher.find();
        String resout=matcher.group(1);
        System.out.println(flag);
        System.out.println(resout);
    }*/


    /*对时间的处理方式1*/
    /*public static void main(String[] args) {
        *//*圆周率*//*
        System.out.println(Math.PI);
        *//*计算当前时间的半小时前*//*
        SimpleDateFormat sfm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -30);
        String date = sfm1.format(calendar.getTime());
        *//*取当前时间一个小时前*//*
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - 1);
        String time = sfm1.format(ca.getTime());
        *//*打印时间*//*
        System.out.println(time);
        System.out.println(date);
    }*/

    /*对时间的处理方式2*/
    /*public static void main(String[] args) {
        Test01API test01API=new Test01API();
        String[] last12Months=test01API.getLast12Months();
            System.out.println(Arrays.toString(last12Months));
    }*/
    /*根据当前年月计算前11个月*/
    /*public  String[] getLast12Months() {
        String time = "2018-10-10 12:00:00";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            date= sdf.parse(time);
        }catch (ParseException e){
            System.out.println(e);
        }
        String[] last12Months = new String[12];
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
        for(int i=0; i<12; i++){
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月
            last12Months[11-i] = cal.get(Calendar.YEAR)+ "-" + addZeroForNum(String.valueOf(cal.get(Calendar.MONTH)+1), 2);
        }
        return last12Months;
    }*/
    /*内部调用*/
   /* public  String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                // sb.append(str).append("0");//右补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }*/

    /*对时间的处理方式3：取上个月的最后一天*/
    /*public static void main(String[] args) {
        int year=2018;
        int month=10;
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-2);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        System.out.println(lastDayOfMonth);
    }*/


    /*格式化字符串的作用01*/
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

    /*格式化字符串的作用02*/
    /*public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("客服消息");
        *//*pattern{} 里是参数index*//*
        String logInfo = MessageFormat.format("经销商编号:{0}, 顾问编号:{1}, 客户编号:{2}, 消息内容:{3}", 111, 222, 333, "经销商详情");
        logger.info(logInfo);
    }*/
}
