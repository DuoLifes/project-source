package com.cn.connext.project.technology.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicLogProxy implements InvocationHandler{
    Object delegate;
    private static final Logger logger = LoggerFactory.getLogger(InvocationHandler.class);
    public Object bind(Object delegate){
        this.delegate=delegate;
        Class cla=delegate.getClass();
        return Proxy.newProxyInstance(cla.getClassLoader(),cla.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method,Object[]args) throws Throwable{
            logger.debug("Before Delete");
            System.out.println(args[0]);
            Object retvalue=method.invoke(delegate,args);
            logger.debug("After Delete");
            return retvalue;
    }
}
