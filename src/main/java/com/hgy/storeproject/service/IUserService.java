package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.User;

public interface IUserService {
    /**
     * 用户注册
     * @param user 用户数据
     */
    void reg(User user);

    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配的用户数据，如果没有则返回null值
     */
    User login(String username,String password);

    /**
     * 修改密码
     * @param uid 当前登录的用户id
     * @param username 用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid,String username, String oldPassword,String newPassword,String renewPassword);

    /**
     * 获取当前登录的用户的信息
     * @param uid 当前登录的用户的id
     * @return 当前登录的用户的信息
     */
    User getByUid(Integer uid);

    /**
     * 获取用户的信息
     * @param email 用户的email
     * @return 当用户的信息
     */
    User getByEmail(String email);

    /**
     * 修改密码
     * @param email 用户email
     * @param newPassword 新密码
     */
    void changePasswordByEmail(String email,String newPassword);

    /**
     * 更新用户信息
     * @param uid 用户uid
     * @param username 用户名字
     * @param email 用户邮箱
     * @param gender 用户性别
     * @param phone 用户电话
     */
    void changeInformationByUid(Integer uid,String username,String email,Integer gender,String phone);

    /**
     * 更新用户介绍
     * @param uid 用户uid
     * @param introduction 用户介绍
     */
    void changeIntroductionByUid(Integer uid,String introduction);

    /**
     * 余额充值
     * @param uid 用户uid
     * @param wallet 受影响行数
     */
    void updateWalletByUid(Integer uid,Double wallet);
}
