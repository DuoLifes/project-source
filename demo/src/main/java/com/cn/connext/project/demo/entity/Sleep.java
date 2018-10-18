package com.cn.connext.project.demo.entity;

public class Sleep implements Person {
    @Override
    public void action(){
        System.out.println("重写action:Sleep-睡觉");
    }
}
