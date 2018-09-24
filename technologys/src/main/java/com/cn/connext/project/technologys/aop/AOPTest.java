package com.cn.connext.project.technologys.aop;

public class AOPTest {
    public static void main(String[] args) {
        UserDao userDao=(UserDao) new DynamicLogProxy().bind(new UserDaoImpl());
        String DelStr=userDao.delete("张三");
        System.out.println(DelStr);

        CustomerDao customerDao=(CustomerDao) new DynamicLogProxy().bind(new CustomerImpl());
        String CreStr=customerDao.create("李四");
        System.out.println(CreStr);
    }
}
