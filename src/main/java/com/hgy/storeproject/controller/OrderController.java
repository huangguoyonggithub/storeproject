package com.hgy.storeproject.controller;

import com.hgy.storeproject.entity.Order;
import com.hgy.storeproject.service.IOrderService;
import com.hgy.storeproject.util.JsonResult;
import com.hgy.storeproject.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController // @Controller + @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer[] cids, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.createOrder(cids,uid,username);
        // 返回成功与数据
        return new JsonResult<Order>(OK, data);
    }
}
