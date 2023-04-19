package com.hgy.storeproject.controller;

import com.hgy.storeproject.service.ICartService;
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
@RequestMapping("carts")
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer gid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行添加到购物车
        cartService.addToCart(uid, gid, username);
        // 返回成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        // 从Session中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<CartVO>>(OK, data);
    }

    @RequestMapping("{cid}/delete_cart")
    public JsonResult<Void> DeleteCart(@PathVariable("cid") Integer cid) {
        // 调用业务对象执行添加到购物车
        cartService.deleteCartVOByCid(cid);
        // 返回成功
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("delete_carts")
    public JsonResult<Void> DeleteCarts(String cid) {
        // 调用业务对象执行添加到购物车
        cartService.deleteCartByCids(cid);
        // 返回成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping({"list"})
    public JsonResult<List<CartVO>> getVOByCids(Integer[] cids,HttpSession session) {
        // 从Session中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByCids(uid,cids);
        // 返回成功与数据
        return new JsonResult<List<CartVO>>(OK, data);
    }
}
