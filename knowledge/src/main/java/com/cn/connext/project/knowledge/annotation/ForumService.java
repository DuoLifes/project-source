package com.cn.connext.project.knowledge.annotation;

/*使用自定义注解*/
public class ForumService {
    @NeedTest//默认false
    public void delete(){
        System.out.println("删除！");
    }
    /*单元测试*/
}
