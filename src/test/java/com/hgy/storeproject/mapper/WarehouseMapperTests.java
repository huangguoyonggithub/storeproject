package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Warehouse;
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
public class WarehouseMapperTests {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Test
    public void insertWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setUid(8);
        warehouse.setGid(777);
        warehouse.setPrice(100.0);
        warehouse.setStatus("gggggggg2");
        warehouseMapper.insertWarehouse(warehouse);
    }

    @Test
    public void findWarehouseByUid() {
        List<Warehouse> warehouses = warehouseMapper.findWarehouseByUid(8);
        for (Warehouse item : warehouses){
            System.out.println(item);
        }
    }

    @Test
    public void updateWarehouseGoodsUser() {
        warehouseMapper.updateWarehouseGoodsUser(9,"gggggggg","admin2",new Date());
    }
}
