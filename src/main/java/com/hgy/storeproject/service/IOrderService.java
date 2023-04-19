package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Order;

public interface IOrderService {
    /**
     * 创建订单
     * @param cids 即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 成功创建的订单数据
     */
    Order createOrder(Integer[] cids, Integer uid, String username);
}
