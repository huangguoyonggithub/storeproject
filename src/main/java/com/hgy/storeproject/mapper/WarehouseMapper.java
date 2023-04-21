package com.hgy.storeproject.mapper;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.entity.OrderItem;
import com.hgy.storeproject.entity.Warehouse;

import java.util.Date;
import java.util.List;

/**订单的持久层接口*/
public interface WarehouseMapper {

    /**
     * 插入个人仓库数据
     * @param warehouse 仓库
     * @return 受影响的行数
     */
    Integer insertWarehouse(Warehouse warehouse);

    /**
     * 查询某用户个人仓库数据
     * @param uid 用户id
     * @return 该用户个人仓库数据或者null
     */
    List<Warehouse> findWarehouseByUid(Integer uid);

    /**
     * 通过交易码获取商品到个人仓库(原理：由于设计数据库时把所有的用户个人仓库都放在一起了，所以只要修改装备的用户即可)
     * @param uid 用户id（表示谁使用的交易码）
     * @param status 装备交易码
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateWarehouseGoodsUser(Integer uid, String status,String modifiedUser, Date modifiedTime);
}
