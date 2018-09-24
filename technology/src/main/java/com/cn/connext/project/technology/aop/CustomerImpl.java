package com.cn.connext.project.technology.aop;


public class CustomerImpl implements CustomerDao {
    public String create(String name){
        return name+"创建成功";
    }
}
