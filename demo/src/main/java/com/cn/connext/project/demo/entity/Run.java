package com.cn.connext.project.demo.entity;

/*基于接口实现多态*/
public class Run implements Person {
    @Override
    public void action(){
        System.out.println("重写action:Run-跑步");
    }
}
