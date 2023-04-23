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
     * @param gid 商品idAS
     * @return 相关的数据，或者NULL
     */
    Good selectGoodById(Integer gid);

    /**
     * 根据gid删除goods装备库里的数据（也就是下架商品）
     * @param gid 商品id
     */
    Integer deleteGoodsByGid(Integer gid);

    /**
     * 出售装备
     * @param uid 用户id
     * @param wid 装备id
     * @param categoryId 装备分类号
     * @param goodType 装备类型
     * @param price 装备价格
     */
    void sellEquipment(Integer uid,Integer wid,Integer categoryId,String goodType,Double price);
 }
