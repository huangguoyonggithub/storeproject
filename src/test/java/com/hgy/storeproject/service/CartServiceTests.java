package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart() {
        try {
            Integer uid = 6;
            Integer pid = 666;
            Integer amount = 10;
            String username = "Tom";
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteCartVOByCid() {
        try {
            Integer cid = 2 ;
            cartService.deleteCartVOByCid(cid);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
