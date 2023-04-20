package com.hgy.storeproject.service;

import com.hgy.storeproject.vo.CartVO;

import java.util.List;

public interface ICartService {
    /**g
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param gid 商品的id
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer gid, String username);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * 查询某用户的购物车列表数量
     * @param uid 用户id
     * @return 该用户的购物车列表数量
     */
    Integer getCountByUid(Integer uid);

    /**
     * 根据cid删除购物车数据
     * @param cid 购物车id
     * @param uid 用户id
     */
    Integer deleteCartVOByCid(Integer cid,Integer uid);

    /**
     * 批量删除cart
     * @param ids cid字符串
     */
    void deleteCartByCids(String ids);

    /**
     * 根据cid数组查询cart数据
     * @param uid 用户id
     * @param cids 商品id数组
     * @return 该用户的购物车数据的多条列表
     */
    List<CartVO> getVOByCids(Integer uid,Integer[] cids);
}
