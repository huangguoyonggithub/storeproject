package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.Sell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellMapperTests {
    @Autowired
    private SellMapper sellMapper;

    @Test
    public void insert() {
        Sell sell = new Sell();
        sell.setCategoryId(1);
        sell.setGoodType("匕首");
        sell.setTitle("牛啊");
        sell.setPrice(100.0);
        sell.setPrices(200.0);
        System.out.println(sellMapper.insertSell(sell));
    }

    @Test
    public void selectAll() {
        List<Sell> sells = sellMapper.selectAllSell(8);
        for (Sell item : sells){
            System.out.println(item);
        }
    }

    @Test
    public void deleteSellByGid() {
        System.out.println(sellMapper.deleteSellByGid(99));
    }
}
