package com.hgy.storeproject.service;

import com.hgy.storeproject.entity.Collect;
import com.hgy.storeproject.vo.CollectVO;

import java.util.List;

public interface ICollectService {

    /**g
     * 将商品添加到收藏
     * @param uid 当前登录用户的id
     * @param gid 商品的id
     */
    void addToCollect(Integer gid, Integer uid, String username);

    /**
     * 查询某用户的收藏数据
     * @param uid 用户id
     * @return 该用户的收藏数据的列表
     */
    List<CollectVO> getCollectVOByUid(Integer uid);

    /**
     * 根据tid删除收藏数据
     * @param tid 收藏id
     */
    void deleteCollectByTid(Integer tid);
}
