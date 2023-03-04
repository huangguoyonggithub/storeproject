package com.hgy.storeproject.service.impl;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.entity.Collect;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.mapper.CartMapper;
import com.hgy.storeproject.mapper.CollectMapper;
import com.hgy.storeproject.service.ICartService;
import com.hgy.storeproject.service.ICollectService;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.ex.AccessDeniedException;
import com.hgy.storeproject.service.ex.CartNotFoundException;
import com.hgy.storeproject.service.ex.DeleteException;
import com.hgy.storeproject.service.ex.InsertException;
import com.hgy.storeproject.vo.CartVO;
import com.hgy.storeproject.vo.CollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private IUserService userService;

    @Override
    public void addToCollect(Integer gid, Integer uid, String username) {
        // 根据参数pid和uid查询收藏中的数据
        Collect result = collectMapper.findByUidAndGid(uid,gid);
        Date now = new Date();
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示该用户并未将该商品添加到收藏
            // 创建Collect对象
            Collect collect = new Collect();
            // 封装数据：uid,pid
            collect.setGid(gid);
            collect.setUid(uid);

            // 封装数据：4个日志
            collect.setCreatedUser(username);
            collect.setCreatedTime(now);
            collect.setModifiedUser(username);
            collect.setModifiedTime(now);
            // 调用insert(collect)执行将数据插入到数据表中
            Integer rows = collectMapper.insertCollect(collect);
            if (rows != 1) {
                throw new InsertException("插入商品数据时出现未知错误，请联系系统管理员");
            }
        }
    }

    @Override
    public List<CollectVO> getCollectVOByUid(Integer uid) {
        User result = userService.getByUid(uid);
        if (result == null){
            throw new AccessDeniedException("用户登录过时,请重新登录");
        }
        return collectMapper.findCollectByUid(uid);
    }

    @Override
    public void deleteCollectByTid(Integer tid) {
        // 根据参数tid查询收藏中的数据
        CollectVO result = collectMapper.findCollectByTid(tid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示没有该购物车信息
            throw new DeleteException("该收藏数据不存在！");
        } else {
            // 否：表示有该购物车信息
            Integer rows = collectMapper.deleteCollectByTid(tid);
            if (rows != 1) {
                throw new DeleteException("删除该收藏数据时产生未知错误！");
            }
        }
    }
}
