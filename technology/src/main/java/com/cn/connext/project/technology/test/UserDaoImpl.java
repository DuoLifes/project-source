package com.cn.connext.project.technology.test;

public class UserDaoImpl implements UserDao{
        public String delete(String name){
            return "删除成功";
        }

    public static void main(String[] args) {
        Customer customer=(Customer) new DynamicLogProxy().bind(new Customer());
        String str=customer.create("张三");
        System.out.println(str);
    }
}
