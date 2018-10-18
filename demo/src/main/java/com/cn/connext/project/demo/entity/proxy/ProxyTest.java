package com.cn.connext.project.demo.entity.proxy;

/*编写测试类*/
/*理解设计模式：代理模式*/
public class ProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        buyHouse.buyHosue();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHosue();
    }
}
