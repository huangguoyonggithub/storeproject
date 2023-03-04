package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.User;
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
public class GoodMapperTests {
    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void selectAll() {
        List<Good> list = goodMapper.selectAllGoods();
        System.out.println("count=" + list.size());
        for (Good item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void select() {
        List<Good> list = goodMapper.selectGoods("爪子");
        System.out.println("count=" + list.size());
        for (Good item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void selectClassGoods() {
        List<Good> list = goodMapper.selectClassGoods(10);
        System.out.println("count=" + list.size());
        for (Good item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void selectRandGoods() {
        List<Good> list = goodMapper.selectRandGoods(8);
        for (Good item : list) {
            System.out.println(item);
        }
    }
}
