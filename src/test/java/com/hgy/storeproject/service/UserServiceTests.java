package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.mapper.UserMapper;
import com.hgy.storeproject.service.ex.ServiceException;
import com.hgy.storeproject.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

// @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解(没有不可运行)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    /**
     *单元测试方法:就可以单独独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须被@Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("hhh2");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("OK!!!");
        } catch (ServiceException e) {
            //获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = userService.login("admin","321");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(6,"管理员","123","321");
    }

    @Test
    public void getByUid() {
        try {
            Integer uid = 6;
            User user = userService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getByEmail() {
        try {
            String email = "25555555555qq.xom";
            User user = userService.getByEmail(email);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changePasswordByEmail(){
        userService.changePasswordByEmail("25555555555qq.xom","321");
    }

}
