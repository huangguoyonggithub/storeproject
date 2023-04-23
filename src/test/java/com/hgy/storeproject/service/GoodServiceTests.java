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
public class GoodServiceTests {
    @Autowired
    private IGoodService goodService;

    @Test
    public void findAllGoodList() {
        try {
            List<Good> list = goodService.selectAllGoods();
            System.out.println("count=" + list.size());
            for (Good item : list) {
                System.out.println(item);
            }
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getPageGoods() {
        List<Good> list = goodService.getPageGoods(2,12);
        System.out.println("count=" + list.size());
        for (Good item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void getSearchGoods() {
        List<Good> list = goodService.selectSearchGoods("爪子");
        System.out.println("count=" + list.size());
        for (Good item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void getClassGoods() {
        List<Good> list = goodService.selectClassGoods(1);
        System.out.println("count=" + list.size());
        for (Good item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void deleteGoodsByGid() {
        goodService.deleteGoodsByGid(1132);
    }

    @Test
    public void sellEquipment() {
        goodService.sellEquipment(8,5,1,"匕首",1500.0);
    }
}
