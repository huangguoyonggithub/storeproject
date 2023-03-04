package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.vo.CartVO;
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
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setGid(2);
        cart.setNum(3);
        cart.setPrice(12.44);
        Integer rows = cartMapper.insertCart(cart);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateNumByCid() {
        Integer cid = 1;
        Integer num = 10;
        String modifiedUser = "购物车管理员";
        Date modifiedTime = new Date();
        Integer rows = cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUidAndPid() {
        Integer uid = 1;
        Integer gid = 2;
        Cart result = cartMapper.findByUidAndGid(uid, gid);
        System.out.println(result);
    }

    @Test
    public void findVOByUid() {
        List<CartVO> list = cartMapper.findVOByUid(6);
        for (CartVO item : list){
            System.out.println(item);
        }
    }

    @Test
    public void findVOByCid() {
        CartVO cart = cartMapper.findVOByCid(2);
        System.out.println(cart);
    }
}
