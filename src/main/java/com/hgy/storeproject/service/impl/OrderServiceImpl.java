package com.hgy.storeproject.service.impl;

import com.hgy.storeproject.entity.*;
import com.hgy.storeproject.mapper.CartMapper;
import com.hgy.storeproject.mapper.OrderMapper;
import com.hgy.storeproject.service.ICartService;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.service.IOrderService;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.ex.AccessDeniedException;
import com.hgy.storeproject.service.ex.DeleteException;
import com.hgy.storeproject.service.ex.InsertException;
import com.hgy.storeproject.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ICartService cartService;

    @Override
    public Order createOrder(Integer[] cids, Integer uid, String username) {
        // 创建当前时间对象
        Date now = new Date();

        // 根据cids查询所勾选的购物车列表中的数据
        List<CartVO> carts = cartService.getVOByCids(uid, cids);

        // 计算这些商品的总价
        Double totalPrice = 0.0;
        for (CartVO cart : carts) {
            totalPrice += cart.getPrice();
        }

        // 创建订单数据对象
        Order order = new Order();
        // 补全数据：uid
        order.setUid(uid);
        // 补全数据：totalPrice
        order.setTotalPrice(totalPrice);
        // 补全数据：下单时间
        order.setOrderTime(now);
        // 补全数据：日志
        order.setCreatedUser(username);
        order.setCreatedTime(now);
        order.setModifiedUser(username);
        order.setModifiedTime(now);
        // 插入订单数据
        Integer rows1 = orderMapper.insertOrder(order);
        if (rows1 != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        // 遍历carts，循环插入订单商品数据
        for (CartVO cart : carts) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：pid, title, image, price, num
            item.setGid(cart.getGid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getPrice());
            item.setStatus(cart.getStatus());
            // 补全数据：4项日志
            item.setCreatedUser(username);
            item.setCreatedTime(now);
            item.setModifiedUser(username);
            item.setModifiedTime(now);
            // 插入订单商品数据
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }

        return order;
    }
}
