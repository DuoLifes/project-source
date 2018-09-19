package com.cn.connext.project.knowledge.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;

@WebAPI("/api/knoledge/demo")
public class DemoAPI {
    //psvm快捷创建main方法
    public static void main(String[] args) {
        String str="This,Server,Is,Knowledge!";
        String[] test = str.split(",");
        for (int i=0;i<test.length;i++) {
            System.out.println("第"+(i+1)+"个元素是:"+test[i]);
        }
    }
}
