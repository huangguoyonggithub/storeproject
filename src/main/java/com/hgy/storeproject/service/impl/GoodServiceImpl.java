package com.hgy.storeproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.mapper.GoodMapper;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements IGoodService {

    @Autowired
    private GoodMapper goodMapper;

//    查询所有（不是分页查询所有）
    @Override
    public List<Good> selectAllGoods() {
        List<Good> list = goodMapper.selectAllGoods();
        return getGoods(list);
    }

    @Override
    public List<Good> getPageGoods(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
//        PageHelper.offsetPage(pageNum,pageSize);//这个方法的pageNum是从第几行数据开始查询
        List<Good> list = goodMapper.selectAllGoods();
        if (list == null){
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        return getGoods(list);
    }

    @Override
    public List<Good> selectSearchGoods(String title) {
        PageHelper.startPage(0,16);
        List<Good> list = goodMapper.selectGoods(title);
        return getGoods(list);
    }

    //公共类
    private List<Good> getGoods(List<Good> list) {
        if (list == null){
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        for (Good good : list) {
            good.setCreatedUser(null);
            good.setCreatedTime(null);
            good.setModifiedUser(null);
            good.setModifiedTime(null);
        }
        return list;
    }

    @Override
    public List<Good> selectClassGoods(Integer categoryId) {
        PageHelper.startPage(0, 16);
        List<Good> list = goodMapper.selectClassGoods(categoryId);
        return getGoods(list);
    }

    @Override
    public List<Good> selectRandGoods(Integer categoryId) {
        List<Good> list = goodMapper.selectRandGoods(categoryId);
        return list;
    }

    @Override
    public Good selectGoodById(Integer gid) {
        Good good = goodMapper.selectGoodByID(gid);
        if (good == null){
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        return good;
    }
}
