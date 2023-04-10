package com.hgy.storeproject.mapper;

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
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * *单元测试方法:就可以单独独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须被@Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     **/

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user02");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void selectByUsername() {
        String username = "user02";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }

    @Test
    public void updatePasswordByUid(){

        userMapper.updatePasswordByUid(7,"321","管理员",new Date());
    }

    @Test
    public void selectByUid(){
        System.out.println(userMapper.findByUid(7));
    }

    @Test
    public void selectAll() {
        List<User> list = userMapper.selectAllUsers();
        System.out.println("count=" + list.size());
        for (User item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void selectByEmail() {
        String email = "25555555555qq.xom";
        User result = userMapper.findByEmail(email);
        System.out.println(result);
    }
}
