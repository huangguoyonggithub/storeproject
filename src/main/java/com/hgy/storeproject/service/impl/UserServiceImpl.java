package com.hgy.storeproject.service.impl;

import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.mapper.UserMapper;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        // 根据参数user对象获取注册的用户名
        String username = user.getUsername();
        // 调用持久层的User findByUsername(String username)方法，根据用户名查询用户数据
        User result = userMapper.findByUsername(username);

        // 判断查询结果是否不为null
        if (result != null) {
            // 是：表示用户名已被占用，则抛出UsernameDuplicateException异常
            throw new UsernameDuplicatedException("尝试注册的用户名[" + username + "]已经被占用");
        }

        // 补全数据：加密后的密码
        //密码加密处理的实现: md5算法的形式:67dhdsgh-yeuwrey121-yerui374-yrwirnei-67123
        //〔串 + password +串) ---- md5算法进行加密，连续加载三次
        //盐值+password +盐值----盐值就是一个随机的字符串
        String oldPassword = user.getPassword();
        //获取盐值(随机生成一个盐值)
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据，盐值的记录
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理,忽略原有密码强度提升了数据的安全性
        String md5Password = getMd5Password(oldPassword,salt);
        //将加密之后的密码重新补全设置到user对象中
        user.setPassword(md5Password);

        //补全数据:4个日志字段信息
        // 创建当前时间对象
        Date now = new Date();
        user.setCreatedTime(now);
        user.setCreatedUser(username);
        user.setModifiedTime(now);
        user.setModifiedUser(username);

        //执行注册业务功能的实现（row==1）
        // 表示用户名没有被占用，则允许注册
        // 调用持久层Integer insert(User user)方法，执行注册并获取返回值(受影响的行数)
        Integer rows = userMapper.insert(user);
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 是：插入数据时出现某种错误，则抛出InsertException异常
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public User login(String username, String password) {
        //根据用户名称来查询用户的数据是否存在，如果不在则抛出异常
        User result = userMapper.findByUsername(username);
        if (result == null){
            throw new UserNotFoundException("用户数据不存在！");
        }
        //检测用户的密码是否匹配
        //1.先获取到数据库中的加密之后的密码
        String oldPassword = result.getPassword();
        //2.和用户的传递过来的密码进行比较
        //2.1先获取盐值:上一次在注册时所自动生成的盐值
        String salt = result.getSalt();
        //2.2将用户的密码按照相同的md5算法的规则进行加密
        String newMd5Password = getMd5Password(password,salt);
        //3.将密码进行比较
        if (!newMd5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("用户密码错误！");
        }


        //调用mapper层的findByUsername来查询用户的数据,提升系统的性能
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());

        //将当前的用户数据返回,返回的数据是为了辅助其他页面做数据展示使用(uid、username、avatar)
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null){
            throw new UserNotFoundException("用户数据不存在！");
        }
        //原始密码和数据库中密码进行比较
        String oldMd5Password = getMd5Password(oldPassword, result.getSalt());
        if( ! result.getPassword( ).equals(oldMd5Password)) {
            throw new PasswordNotMatchException("密码错误！");
        }
        //将新的密码进行加密并加入到数据库中
        String newMd5Password = getMd5Password(newPassword, result.getSalt());
        Integer  rows = userMapper.updatePasswordByUid(uid,newMd5Password,username,new Date());
        if (rows != 1){
            throw  new UpdateException("更新时产生未知异常！");
        }

    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);

        if (result == null){
            throw new UserNotFoundException("用户数据不存在！");
        }



        // 创建新的User对象
        User user = new User();
        // 将以上查询结果中的username/phone/email/gender封装到新User对象中
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        // 返回新的User对象
        return user;

    }

    @Override
    public User getByEmail(String email) {
        User result = userMapper.findByEmail(email);

        if (result == null){
            throw new UserNotFoundException("该email没有被注册！");
        }

        // 创建新的User对象
        User user = new User();
        // 将以上查询结果中的username/phone/email/gender封装到新User对象中
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        // 返回新的User对象
        return user;
    }

    /**
     * 执行密码加密,定义一个MD5算法的加密处理
     * @param password 原始密码
     * @param salt 盐值
     * @return 加密后的密文
     */
    private String getMd5Password(String password, String salt) {
        /*
         * 加密规则：
         * 1、无视原始密码的强度
         * 2、使用UUID作为盐值，在原始密码的左右两侧拼接
         * 3、循环加密3次
         */
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }


}
