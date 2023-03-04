package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Good;

import java.util.List;

public interface IGoodService {

    /**
     * 查询所有（不是分页查询所有）
     * @return 热销商品前四名的集合
     */
    List<Good> selectAllGoods();

    /**
     * 分页实现
     * @param pageNum 从第几页开始查
     * @param pageSize 每页条数
     * @return 每页的数据，或者NULL
     */
    List<Good> getPageGoods(Integer pageNum,Integer pageSize);

    /**
     * 通过title模糊查询
     * @param title 想要搜索的数据
     * @return 相关的数据，或者NULL
     */
    List<Good> selectSearchGoods(String title);

    /**
     * 分类查询商品数据
     * @param categoryId 分类ID
     * @return 相关的数据，或者NULL
     */
    List<Good> selectClassGoods(Integer categoryId);

    /**
     * 随机查询商品
     * @return 相关的数据，或者NULL
     */
    List<Good> selectRandGoods(Integer categoryId);

    /**
     * 根据gid查询商品数据
     * @param gid 商品id
     * @return 相关的数据，或者NULL
     */
    Good selectGoodById(Integer gid);
 }
