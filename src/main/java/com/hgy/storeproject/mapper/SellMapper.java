package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Sell;

import java.util.List;

public interface SellMapper {
    /**
     * 出售商品
     * @param sell 商品
     * @return 受影响的行数
     */
    Integer insertSell(Sell sell);

    Integer deleteSellByGid(Integer gid);

    List<Sell> selectAllSell(Integer uid);

    Sell selectSellByGid(Integer gid);

}
