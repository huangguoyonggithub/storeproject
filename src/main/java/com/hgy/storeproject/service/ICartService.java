package com.hgy.storeproject.service;

import com.hgy.storeproject.vo.CartVO;

import java.util.List;

public interface ICartService {
    /**g
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param gid 商品的id
     * @param amount 增加的数量
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer gid, Integer amount, String username);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * 根据cid删除购物车数据
     * @param cid 购物车id
     */
    void deleteCartVOByCid(Integer cid);

    /**
     * 将购物车中某商品的数量加1
     * @param cid 购物车数量的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);

    /**
     * 将购物车中某商品的数量减1
     * @param cid 购物车数量的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 增加成功后新的数量
     */
    Integer minusNum(Integer cid, Integer uid, String username);
}
