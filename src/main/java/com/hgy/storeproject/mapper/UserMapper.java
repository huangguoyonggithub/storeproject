package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.User;

import java.util.Date;
import java.util.List;

/** 处理用户数据操作的持久层接口 */
public interface UserMapper {

    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名（用户名唯一）
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findByUsername(String username);

    /**
     * 根据用户id查询用户的数据
     * @param uid 用户id
     * @return 如果找到返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     * 根据用户email查询用户的数据
     * @param email 用户email
     * @return 如果找到返回对象，反之返回null
     */
    User findByEmail(String email);

    /**
     *根据用户的uid来修改用户的密码
     * @param uid 用户id
     * @param password 用户输入的新密码
     * @param modifiedUser 修改的执行者
     * @param modifiedTime 修改的时间
     * @return 返回值受影向的行数
     */
    Integer updatePasswordByUid(Integer uid, String password,
                                String modifiedUser, Date modifiedTime);

    /**
     * 查询全部用户数据
     * @return 如果找到返回对象，反之返回null
     */
    List<User> selectAllUsers();

    /**
     *根据用户的email来修改用户的密码
     * @param email 用户email
     * @param password 用户输入的新密码
     * @param modifiedTime 修改的时间
     * @return 返回值受影向的行数
     */
    Integer updatePasswordByEmail(String email, String password, Date modifiedTime);
}
