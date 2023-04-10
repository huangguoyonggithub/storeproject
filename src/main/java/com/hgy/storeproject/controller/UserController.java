package com.hgy.storeproject.controller;

import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController // @Controller + @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    /**
     * *约定大于配置:开发思想来完成，省略大量的配置甚至注解的编写***********
     * 1.接收数据方式:请求处理方法的参数列表设置为pojo(对象)类型来接收前端的数据，
     * SpringBoot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果
     * 这两个名称项目，则将值注入到pojo类中对应的属性井
     * @param user
     * @return
     */
    @RequestMapping("reg")
    // @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<Void>(OK);
    }

    /**
     * 2.接收数据方式:请求处理方法的参数列表设置为非pojo（对象）类型
     * SpringBoot会直接将请求的参数名和方法的参数名直接进行比较，
     * 如果名称相同则自动完成值的依赖注入
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username,password);

        if (data == null){
            System.out.println("登录是产生未知错误！");
        }

        //向session对象中完成数据的绑定（session是全局的）
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

//        //获取session中绑定的数据
//        System.out.println(getUidFromSession(session));
//        System.out.println(getUsernameFromSession(session));

        JsonResult<User> result = new JsonResult<User>(OK,data);
//        System.out.println(result);
        return result;
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        // 从HttpSession对象中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行获取数据
        User data = userService.getByUid(uid);
        // 响应成功和数据
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("get_username")
    public JsonResult<String> getUsername(HttpSession session) {
        // 从HttpSession对象中获取username
        String data = getUsernameFromSession(session);

        // 响应成功和数据
        return new JsonResult<String>(OK, data);
    }

    @RequestMapping("get_by_email")
    public JsonResult<User> getByEmail(String email) {
        // 调用业务对象执行获取数据
        User data = userService.getByEmail(email);
//        System.out.println(data);
        // 响应成功和数据
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_password_by_email")
    public JsonResult<Void> changePasswordByEmail(String email,String newPassword){
        userService.changePasswordByEmail(email,newPassword);
        return new JsonResult<Void>(OK);
    }
}
