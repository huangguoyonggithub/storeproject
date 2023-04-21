package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;

import java.util.List;

public interface IOrderService {
    /**
     * 创建订单
     * @param cids 即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 成功创建的订单数据
     */
    Order createOrder(Integer[] cids, Integer uid, String username);

    /**
     * 根据uid查找用户已付款的商品数据
     * @param uid 用户id
     * @return 该用户已付款的商品数据或者null
     */
    List<OrderItem> findOrderItemByUid(Integer uid);

    /**
     * 根据uid查找该用户订单的商品数据
     * @param uid 用户id
     * @param oid 订单id
     * @return 该用户订单的商品数据或者null
     */
    List<OrderItem> findOrderItemByUidAndOid(Integer uid,Integer oid);

    /**
     * 根据uid查找该用户订单数据
     * @param uid 用户id
     * @param oid 订单id
     * @return 该用户订单数据或者null
     */
    Order findOrder(Integer uid,Integer oid);
}
