package com.cn.connext.project.technologys.webapi;

import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.technologys.entity.Orders;
import com.cn.connext.project.technologys.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import java.util.List;

@WebAPI("/api/technology/orders")
public class OrdersAPI {
    @Resource
    private OrderRepository orderRepository;

    //验证@MappedSuperclass注解定义实体通用属性
    @GetMapping("/findAll")
    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

    //创建实体：自动添加创建人；创建时间
    @GetMapping("/create")
    public Orders aa(){
        Orders orders=new Orders();
        orders.setId("003");
        orders.setName("网络单");
        return orderRepository.save(orders);
    }
}