package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;
import java.util.List;

public interface CartMapper {
    /**
     * 插入购物车数据
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insertCart(Cart cart);

    /**
     * 修改购物车数据中商品的数量
     * @param cid 购物车数据的id
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户id和商品id查询购物车中的数据
     * @param uid 用户id
     * @param gid 商品id
     * @return 匹配的购物车数据，如果该用户的购物车中并没有该商品，则返回null
     */
    Cart findByUidAndGid(
            @Param("uid") Integer uid,
            @Param("gid") Integer gid);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO> findVOByUid(Integer uid);

    /**
     * 查询某用户的购物车列表数量
     * @param uid 用户id
     * @return 该用户的购物车列表数量
     */
    Integer findCountByUid(Integer uid);

    /**
     * 查询某购物车数据
     * @param cid 购物车id
     * @return 该购物车数据
     */
    CartVO findVOByCid(Integer cid);

    /**
     * 根据cid删除购物车数据
     * @param cid 购物车id
     * @return 受影响的行数
     */
    Integer deleteCartVOByCid(Integer cid);

    /**
     * 批量删除cart
     * @param ids cid数组
     * @return 受影响的行数
     */
    Integer deleteCartByCids(String[] ids);

    /**
     * 根据cid数组查询数据
     * @param cids cid数组
     * @return 找到的多个数据或者null
     */
    List<CartVO> findVOByCids(Integer[] cids);
}
