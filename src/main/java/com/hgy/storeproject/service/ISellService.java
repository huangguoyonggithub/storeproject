package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Sell;

import java.util.List;

public interface ISellService {

    /**
     * 查询所有出售商品
     * @return 所有出售商品数据或者null
     */
    List<Sell> selectAllSell(Integer uid);
 }
