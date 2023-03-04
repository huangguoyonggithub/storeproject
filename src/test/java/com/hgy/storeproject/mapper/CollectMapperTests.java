package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.entity.Collect;
import com.hgy.storeproject.vo.CartVO;
import com.hgy.storeproject.vo.CollectVO;
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
public class CollectMapperTests {
    @Autowired
    private CollectMapper collectMapper;

    @Test
    public void insertCollect() {
        Collect collect = new Collect();
        collect.setUid(1);
        collect.setGid(2);
        Integer rows = collectMapper.insertCollect(collect);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUidAndPid() {
        Integer uid = 1;
        Integer gid = 2;
        Collect result = collectMapper.findByUidAndGid(uid,gid);
        System.out.println(result);
    }

    @Test
    public void findCollectVOByUid() {
        List<CollectVO> list = collectMapper.findCollectByUid(6);
        for (CollectVO item : list){
            System.out.println(item);
        }
    }

    @Test
    public void findCollectVOByTid() {
        CollectVO cart = collectMapper.findCollectByTid(1);
        System.out.println(cart);
    }

    @Test
    public void DeleteCollectByTid() {
        Integer a = collectMapper.deleteCollectByTid(1);
        System.out.println(a);
    }
}
