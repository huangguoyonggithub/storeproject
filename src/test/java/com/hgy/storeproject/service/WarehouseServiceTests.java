package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;
import com.hgy.storeproject.entity.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class WarehouseServiceTests {
    @Autowired
    private IWarehouseService warehouseService;

    @Test
    public void createWarehouse(){
        Warehouse warehouse = warehouseService.createWarehouse(9,4);
        System.out.println(warehouse);
    }

    @Test
    public void findWarehouseByUid(){
        List<Warehouse> warehouses = warehouseService.findWarehouseByUid(9);
        for (Warehouse item : warehouses){
            System.out.println(item);
        }
    }

    @Test
    public void updateWarehouseGoodsUser(){
        System.out.println(warehouseService.updateWarehouseGoodsUser(8,"9ACB44549B41563697BB490144EC625846"));
    }
}
