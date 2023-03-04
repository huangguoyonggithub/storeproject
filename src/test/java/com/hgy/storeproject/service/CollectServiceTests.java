package com.hgy.storeproject.service;

import com.hgy.storeproject.service.ex.ServiceException;
import com.hgy.storeproject.vo.CollectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectServiceTests {
    @Autowired
    private ICollectService collectService;

    @Test
    public void addToCollect() {
        try {
            Integer uid = 6;
            Integer gid = 666;
            String username = "Tom";
            collectService.addToCollect(gid,uid,username);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getCollectVOByUid() {
        try {
            Integer uid = 6;
            List<CollectVO> list = collectService.getCollectVOByUid(uid);
            for (CollectVO item : list){
                System.out.println(item);
            }
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteCollectVOByTid() {
        try {
            Integer tid = 2 ;
            collectService.deleteCollectByTid(tid);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
