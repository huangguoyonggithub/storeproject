package com.hgy.storeproject.service.impl;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;
import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.entity.Warehouse;
import com.hgy.storeproject.mapper.OrderMapper;
import com.hgy.storeproject.mapper.WarehouseMapper;
import com.hgy.storeproject.service.ICartService;
import com.hgy.storeproject.service.IOrderService;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.IWarehouseService;
import com.hgy.storeproject.service.ex.DeleteException;
import com.hgy.storeproject.service.ex.InsertException;
import com.hgy.storeproject.service.ex.OrderItemNotFoundException;
import com.hgy.storeproject.service.ex.UserNotFoundException;
import com.hgy.storeproject.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IUserService userService;


    @Override
    public Warehouse createWarehouse(Integer uid,Integer mid) {
        User user = userService.getByUid(uid);
        if (user == null){
            throw new UserNotFoundException("没有用户登录异常");
        }

        OrderItem orderItem = orderMapper.findOrderItemByMid(mid);
        if (orderItem == null){
            throw new OrderItemNotFoundException("已购商品数据不存在异常");
        }

        Warehouse warehouse = new Warehouse();
        warehouse.setUid(uid);
        //补全基本信息
        warehouse.setGid(orderItem.getGid());
        warehouse.setPrice(orderItem.getPrice());
        warehouse.setTitle(orderItem.getTitle());
        warehouse.setImage(orderItem.getImage());
        warehouse.setStatus(orderItem.getStatus());

        //补全数据:4个日志字段信息
        Date now = new Date();
        warehouse.setCreatedTime(now);
        warehouse.setCreatedUser(user.getUsername());
        warehouse.setModifiedTime(now);
        warehouse.setModifiedUser(user.getUsername());

        Integer rows = warehouseMapper.insertWarehouse(warehouse);
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 是：插入数据时出现某种错误，则抛出InsertException异常
            throw new InsertException("添加个人仓库时出现未知错误，请联系系统管理员");
        }

        //删除加入仓库的已购商品数据
        orderMapper.deleteOrderItemByMid(orderItem.getMid());

        return warehouse;
    }

    @Override
    public List<Warehouse> findWarehouseByUid(Integer uid) {
        User user = userService.getByUid(uid);
        if (user == null){
            throw new UserNotFoundException("没有用户登录异常");
        }

        return warehouseMapper.findWarehouseByUid(uid);
    }

    @Override
    public Warehouse findWarehouseByWid(Integer uid, Integer wid) {
        User user = userService.getByUid(uid);
        if (user == null){
            throw new UserNotFoundException("没有用户登录异常");
        }

        return warehouseMapper.findWarehouseByWid(wid);
    }


    @Override
    public Integer updateWarehouseGoodsUser(Integer uid, String status) {
        User user = userService.getByUid(uid);
        if (user == null){
            throw new UserNotFoundException("没有用户登录异常");
        }

        return warehouseMapper.updateWarehouseGoodsUser(uid,status,user.getUsername(),new Date());
    }


}
