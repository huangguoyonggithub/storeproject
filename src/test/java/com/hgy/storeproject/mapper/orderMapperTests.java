package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class orderMapperTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setUid(8);
        order.setTotalPrice(1008.0);
        orderMapper.insertOrder(order);
    }

    @Test
    public void insertOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setGid(26);
        orderItem.setTitle("锯齿爪刀（★） | 枯焦之色 (略有磨损)");
        orderItem.setPrice(1599.5);
        orderItem.setImage("https://g.fp.ps.netease.com/market/file/5b680b32143cfad337d94d3eOHejWez5");
        orderItem.setCreatedTime(new Date());
        orderItem.setCreatedUser("admin");
        orderMapper.insertOrderItem(orderItem);
    }
}
