package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.demo.entity.Outer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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

    /*对集合的处理stream().map()和stream().forEach()*/
    /*public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = num.stream().map(n -> n * 2).collect(Collectors.toList());
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        num.stream().forEach(n ->hashtable.put(n,n));
        System.out.println(collect); //[2, 4, 6, 8, 10]
        System.out.println(hashtable.toString());
    }*/

    /*休眠:相当于Thread.sleep(3000);*/
    /*public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            try {
                System.out.println("第:"+i+"次循环");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*全局异常设置*/
    /*public static void main(String[] args) {
        String result=null;
        if(StringUtils.isEmpty(result)){
            throw new ServiceException("string_error_idEmpty");
        }
    }*/

    /*list元素按大小排序：int型*/
    /*public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(8);
        list.add(6);
        list.add(4);
        list.add(10);
        *//*正序排序*//*
        Collections.sort(list,(m1,m2)->m1.compareTo(m2));
        System.out.println(list);
    }*/

    /*计算两个小数的商，结果取4位有效数字*/
    /*public static void main(String[] args) {
        BigDecimal temp1 = new BigDecimal(String.valueOf(12.24443));
        BigDecimal temp2 = new BigDecimal(String.valueOf(16.23456));
        System.out.println(String.valueOf(temp1.divide(temp2,4,BigDecimal.ROUND_HALF_UP).doubleValue()));
    }*/

    /*long转double*/
    /*public static void main(String[] args) {
        double a=Double.longBitsToDouble(12);
        double b=Double.longBitsToDouble(23);
        double x=12;
        double y=23;
        double c=a/b;
        double z=x/y;
        System.out.println(c);
        System.out.println(z);
    }*/

    /*内部类调用测试*/
    /*public static void main(String[] args) {
        String str="测试字符串hash值";
        System.out.println(str.hashCode());
        Outer outer=new Outer();
        Outer.Inside_One inside_one=outer.new Inside_One();
        inside_one.test();
        Outer.Inside_Two inside_two=new Outer.Inside_Two();
        inside_two.test();
    }*/

    public static void main(String[] args) {

    }

}
