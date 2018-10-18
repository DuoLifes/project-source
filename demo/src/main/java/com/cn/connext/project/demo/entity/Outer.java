package com.cn.connext.project.demo.entity;

public class Outer {

    public class Inside_One{

        public void test(){
            System.out.println("内部类1方法已调用");
        }
    }

    public static class Inside_Two{
        public void test(){
            System.out.println("内部类2方法已调用");
        }
    }
}
