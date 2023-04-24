package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Warehouse;

import java.util.List;

public interface IWarehouseService {
    /**
     * 创建个人仓库
     * @param uid 用户id
     * @param mid 已购商品id
     * @return 成功创建的个人仓库数据
     */
    Warehouse createWarehouse(Integer uid,Integer mid);

    /**
     * 根据uid查找用户个人仓库的商品数据
     * @param uid 用户id
     * @return 该用户个人仓库的商品数据或者null
     */
    List<Warehouse> findWarehouseByUid(Integer uid);

    /**
     * 根据wid查找某个商品数据
     * @param uid 用户id
     * @param wid 商品id
     * @return 该仓库的某个商品数据或者null
     */
    Warehouse findWarehouseByWid(Integer uid,Integer wid);

    /**
     * 根据交易码获取装备
     * @param uid 任意用户id
     * @param status 交易码 （交易码谁都可以用）
     * @return 受影响行数
     */
    Integer updateWarehouseGoodsUser(Integer uid, String status);
}
