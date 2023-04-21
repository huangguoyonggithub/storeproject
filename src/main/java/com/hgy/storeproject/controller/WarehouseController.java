package com.hgy.storeproject.controller;

import com.hgy.storeproject.entity.OrderItem;
import com.hgy.storeproject.entity.Warehouse;
import com.hgy.storeproject.service.IWarehouseService;
import com.hgy.storeproject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController // @Controller + @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
@RequestMapping("warehouses")
public class WarehouseController extends BaseController{
    @Autowired
    private IWarehouseService warehouseService;

    @RequestMapping("create")
    public JsonResult<Warehouse> createWarehouse(Integer mid, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行业务
        Warehouse data = warehouseService.createWarehouse(uid,mid);
        // 返回成功与数据
        return new JsonResult<Warehouse>(OK, data);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Warehouse>> findWarehouses(HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行业务
        List<Warehouse> data = warehouseService.findWarehouseByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<Warehouse>>(OK, data);
    }

    @RequestMapping("{status}/use_status")
    public JsonResult<Void> findOrderItemByOid(@PathVariable("status")String status,HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        warehouseService.updateWarehouseGoodsUser(uid,status);
        // 返回成功与数据
        return new JsonResult<Void>(OK);
    }
}
