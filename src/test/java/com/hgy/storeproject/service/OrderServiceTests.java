package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void createOrder(){
//        Order createOrder(Integer[] cids, Integer uid, String username);
        Integer[] cids = {39,40};
        Order order = orderService.createOrder(cids,8,"admin");
        System.out.println(order);
    }

    @Test
    public void findOrderItemByUidAndOid(){
        List<OrderItem> orderItems = orderService.findOrderItemByUidAndOid(8,5);
        for (OrderItem items : orderItems){
            System.out.println(orderItems);
        }
    }

    @Test
    public void findOrder(){
        Order order = orderService.findOrder(8,5);
        System.out.println(order);
    }
}
