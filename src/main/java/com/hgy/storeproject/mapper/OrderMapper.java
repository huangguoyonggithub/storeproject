package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;

import java.util.List;

/**订单的持久层接口*/
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param order 订单
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单项数据
     * @param orderItem 每一个订单数项数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<OrderItem> findOrderItemByUid(Integer uid);
}
