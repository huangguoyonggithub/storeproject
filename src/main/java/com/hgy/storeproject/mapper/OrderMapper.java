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
     * 查询某用户已付款商品信息
     * @param uid 用户id
     * @return 该用户已付款商品信息列表或者null
     */
    List<OrderItem> findOrderItemByUid(Integer uid);

    /**
     * 查询某用户的某个订单的商品信息
     * @param uid 用户id
     * @param oid 订单id
     * @return 该用户某个订单的商品信息或者null
     */
    List<OrderItem> findOrderItemByUidAndOid(Integer uid,Integer oid);

    /**
     * 查询某个订单的信息
     * @param uid 用户id
     * @param oid 订单id
     * @return 某个订单的信息或者null
     */
    Order findOrder(Integer uid,Integer oid);

    /**
     * 根据mid查询已购商品的某商品数据
     * @param mid 已购商品id
     * @return 已购商品的某商品数据或者null
     */
    OrderItem findOrderItemByMid(Integer mid);
}
