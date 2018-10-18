package com.cn.connext.project.demo.entity;

public class Run implements Person {
    @Override
    public void action(){
        System.out.println("重写action:Run-跑步");
    }
}
