package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.User;

import java.util.List;

public interface GoodMapper {
    /**
     * 查询全部商品数据（随机排序的数据）
     * @return 如果找到返回对象，反之返回null
     */
    List<Good> selectAllGoods();

    /**
     * 模糊查询某商品数据
     * @return 如果找到返回对象，反之返回null
     */
    List<Good> selectGoods(String title);

    /**
     * 分类查询商品数据
     * @return 如果找到返回对象，反之返回null
     */
    List<Good> selectClassGoods(Integer categoryId);

    /**
     * 随机查询商品
     * @return 如果找到返回对象，反之返回null
     */
    List<Good> selectRandGoods(Integer categoryId);

    /**
     * 根据gid查询商品数据
     * @param gid 商品id
     * @return 如果找到返回对象，反之返回null
     */
    Good selectGoodByID(Integer gid);

    /**
     * 根据gid删除装备库数据
     * @param gid 装备id
     * @return 受影响的行数
     */
    Integer deleteGoodsByGid(Integer gid);

    /**
     * 插入商品
     * @param good 商品
     * @return 受影响的行数
     */
    Integer insertGood(Good good);
}
