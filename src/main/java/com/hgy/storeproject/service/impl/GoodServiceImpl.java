package com.hgy.storeproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.Sell;
import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.entity.Warehouse;
import com.hgy.storeproject.mapper.GoodMapper;
import com.hgy.storeproject.mapper.SellMapper;
import com.hgy.storeproject.mapper.WarehouseMapper;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.ex.DeleteException;
import com.hgy.storeproject.service.ex.InsertException;
import com.hgy.storeproject.service.ex.ProductNotFoundException;
import com.hgy.storeproject.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodServiceImpl implements IGoodService {

    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private SellMapper sellMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private WarehouseMapper warehouseMapper;

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

    @Override
    public Integer deleteGoodsByGid(Integer gid) {
        return  goodMapper.deleteGoodsByGid(gid);
    }

    //卖出商品
    @Override
    public void sellEquipment(Integer uid, Integer wid, Integer categoryId, String goodType,Double price) {
        User user = userService.getByUid(uid);
        if (user == null){
            throw new UserNotFoundException("用户数据不存在，请联系管理员");
        }

        Warehouse warehouse = warehouseMapper.findWarehouseByWid(wid);
        if (warehouse == null){
            throw new ProductNotFoundException("装备数据不存在");
        }

        //创建当前时间
        Date now = new Date();

        //插入商品库
        Good good = new Good();
        good.setCategoryId(categoryId);
        good.setGoodType(goodType);
        good.setPrice(price);
        good.setPrices(price * 1.2);
        //插入基本数据
        good.setTitle(warehouse.getTitle());
        good.setImage(warehouse.getImage());
        good.setStatus(warehouse.getStatus());
        //插入时间等等
        good.setCreatedTime(now);
        good.setCreatedUser(user.getUsername());
        good.setModifiedTime(now);
        good.setModifiedUser(user.getUsername());
        Integer row = goodMapper.insertGood(good);
        if (row != 1){
            throw new InsertException("插入商品时产生错误！");
        }

        //个人出售的商品
        Sell sell = new Sell();
        sell.setUid(uid);
        sell.setGid(warehouse.getGid());
        sell.setCategoryId(categoryId);
        sell.setGoodType(goodType);
        sell.setPrice(price);
        sell.setPrices(price * 1.2);
        //插入基本数据
        sell.setTitle(warehouse.getTitle());
        sell.setImage(warehouse.getImage());
        sell.setStatus(warehouse.getStatus());
        //插入时间等等
        sell.setCreatedTime(now);
        sell.setCreatedUser(user.getUsername());
        sell.setModifiedTime(now);
        sell.setModifiedUser(user.getUsername());
        Integer row2 = sellMapper.insertSell(sell);
        if (row2 != 1){
            throw new InsertException("插入商品时产生错误！");
        }

        //删除仓库以出售商品
        Integer row3 = warehouseMapper.deleteWarehouseByWid(wid);
        if (row3 != 1){
            throw new DeleteException("删除商品时发生未知异常");
        }
    }
}
