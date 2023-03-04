package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Cart;
import com.hgy.storeproject.entity.Collect;
import com.hgy.storeproject.vo.CollectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    /**
     * 插入收藏数据
     * @param collect 收藏数据
     * @return 受影响的行数
     */
    Integer insertCollect(Collect collect);

    /**
     * 根据用户id和商品id查询收藏中的数据
     * @param uid 用户id
     * @param gid 商品id
     * @return 匹配的收藏数据，如果该用户的收藏中并没有该商品，则返回null
     */
    Collect findByUidAndGid(
            @Param("uid") Integer uid,
            @Param("gid") Integer gid);

    /**
     * 查询某收藏数据
     * @param tid 收藏id
     * @return 该购物车数据
     */
    CollectVO findCollectByTid(Integer tid);

    /**
     * 查询某用户的收藏数据
     * @param uid 用户id
     * @return 该用户的收藏数据的列表
     */
    List<CollectVO> findCollectByUid(Integer uid);

    /**
     * 根据tid删除收藏数据
     * @param tid 收藏id
     * @return 受影响的行数
     */
    Integer deleteCollectByTid(Integer tid);
}
