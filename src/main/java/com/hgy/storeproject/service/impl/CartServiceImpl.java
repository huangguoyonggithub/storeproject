package com.hgy.storeproject.service.impl;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.mapper.CartMapper;
import com.hgy.storeproject.service.ICartService;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.ex.AccessDeniedException;
import com.hgy.storeproject.service.ex.CartNotFoundException;
import com.hgy.storeproject.service.ex.DeleteException;
import com.hgy.storeproject.service.ex.InsertException;
import com.hgy.storeproject.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private IGoodService goodService;
    @Autowired
    private IUserService userService;

    @Override
    public void addToCart(Integer uid, Integer gid, Integer amount, String username) {
        // 根据参数pid和uid查询购物车中的数据
        Cart result = cartMapper.findByUidAndGid(uid, gid);
        Date now = new Date();
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示该用户并未将该商品添加到购物车
            // 创建Cart对象
            Cart cart = new Cart();
            // 封装数据：uid,pid,amount
            cart.setUid(uid);
            cart.setGid(gid);
            cart.setNum(amount);
            // 调用productService.findById(pid)查询商品数据，得到商品价格
            Good good = goodService.selectGoodById(gid);
            // 封装数据：price
            cart.setPrice(good.getPrice());
            // 封装数据：4个日志
            cart.setCreatedUser(username);
            cart.setCreatedTime(now);
            cart.setModifiedUser(username);
            cart.setModifiedTime(now);
            // 调用insert(cart)执行将数据插入到数据表中
            Integer rows = cartMapper.insertCart(cart);
            if (rows != 1) {
                throw new InsertException("插入商品数据时出现未知错误，请联系系统管理员");
            }
        } else {
            // 否：表示该用户的购物车中已有该商品
            // 从查询结果中获取购物车数据的id
            Integer cid = result.getCid();
            // 从查询结果中取出原数量，与参数amount相加，得到新的数量
            Integer num = result.getNum() + amount;
            // 执行更新数量
            Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
            if (rows != 1) {
                throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        User result = userService.getByUid(uid);
        if (result == null){
            throw new AccessDeniedException("用户登录过时,请重新登录");
        }
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer getCountByUid(Integer uid) {
        User result = userService.getByUid(uid);
        if (result == null){
            throw new AccessDeniedException("用户登录过时,请重新登录");
        }
        return cartMapper.findCountByUid(uid);
    }


    @Override
    public void deleteCartVOByCid(Integer cid) {
        // 根据参数cid查询购物车中的数据
        CartVO result = cartMapper.findVOByCid(cid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示没有该购物车信息
            throw new DeleteException("该购物车数据不存在！");
        } else {
            // 否：表示有该购物车信息
            Integer rows = cartMapper.deleteCartVOByCid(cid);
            if (rows != 1) {
                throw new DeleteException("删除该购物车数据时产生未知错误！");
            }
        }
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        // 调用findVOByCid(cid)根据参数cid查询购物车数据
        CartVO result = cartMapper.findVOByCid(cid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出CartNotFoundException
            throw new CartNotFoundException("尝试访问的购物车数据不存在");
        }

        // 判断查询结果中的uid与参数uid是否不一致
        if (!result.getUid().equals(uid)) {
            // 是：抛出AccessDeniedException
            throw new AccessDeniedException("非法访问");
        }

        // 可选：检查商品的数量是否大于多少(适用于增加数量)或小于多少(适用于减少数量)
        // 根据查询结果中的原数量增加1得到新的数量num
        Integer num = result.getNum() + 1;

        // 创建当前时间对象，作为modifiedTime
        Date now = new Date();
        // 调用updateNumByCid(cid, num, modifiedUser, modifiedTime)执行修改数量
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        if (rows != 1) {
            throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
        }

        // 返回新的数量
        return num;
    }

    @Override
    public Integer minusNum(Integer cid, Integer uid, String username) {
        // 调用findByCid(cid)根据参数cid查询购物车数据
        CartVO result = cartMapper.findVOByCid(cid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出CartNotFoundException
            throw new CartNotFoundException("尝试访问的购物车数据不存在");
        }

        // 判断查询结果中的uid与参数uid是否不一致
        if (!result.getUid().equals(uid)) {
            // 是：抛出AccessDeniedException
            throw new AccessDeniedException("非法访问");
        }

        // 可选：检查商品的数量是否大于多少(适用于增加数量)或小于多少(适用于减少数量)
        // 根据查询结果中的原数量增加1得到新的数量num
        Integer num = 0;
        if (result.getNum() > 0){
            num = result.getNum() - 1;
        }

        // 创建当前时间对象，作为modifiedTime
        Date now = new Date();
        // 调用updateNumByCid(cid, num, modifiedUser, modifiedTime)执行修改数量
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        if (rows != 1) {
            throw new InsertException("修改商品数量时出现未知错误，请联系系统管理员");
        }

        // 返回新的数量
        return num;
    }
}
