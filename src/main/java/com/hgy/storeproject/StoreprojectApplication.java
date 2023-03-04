package com.hgy.storeproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//自动加载Mapper文件
@MapperScan("com.hgy.storeproject.mapper")
public class StoreprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreprojectApplication.class, args);
    }

}
