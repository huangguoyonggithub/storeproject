package com.hgy.storeproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreprojectApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    //HikariProxyConnection@1048274391 wrapping com.mysql.cj.jdbc.ConnectionImpl@3c854752
    //Hikari：数据库连接池，管理数据库连接对象
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
