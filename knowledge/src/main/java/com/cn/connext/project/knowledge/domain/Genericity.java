package com.cn.connext.project.knowledge.domain;

import com.cn.connext.project.knowledge.entity.Media;

import java.util.ArrayList;
import java.util.List;

/*测试泛型的使用*/
public class Genericity<T> {
    public List<T> list;

    /*通过泛型传入的实体集合截取前两个元素并返回*/
    public List<T> toList(){
        /*
        *验证传入的泛型T确实是Media实体
        * 是则输出true,否则输出false
        */
        this.list.forEach(t -> {
            boolean flag=false;
            if(t.getClass()==Media.class){
                flag=true;
                System.out.println("flag="+flag);
            }else{
                System.out.println("flag="+flag);
            }
        });
        /*业务逻辑:截取前两个元素并返回*/
        List<T> tList=new ArrayList<>();
        tList.add(this.list.get(0));
        tList.add(this.list.get(1));
        return tList;
    }
}
