package com.hgy.storeproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController // @Controller + @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
@RequestMapping("goods")
public class GoodController extends BaseController{
    @Autowired
    private IGoodService goodService;

    @RequestMapping("{pageNum}/get_page")
    public JsonResult<PageInfo<Good>> getPageList(@PathVariable("pageNum") Integer pageNum) {
        List<Good> goods = goodService.getPageGoods(pageNum,16);
//        System.out.println(pageNum);
        PageInfo<Good>  data = new PageInfo<Good>(goods);
        return new JsonResult<PageInfo<Good>>(OK, data);
    }

    @RequestMapping("{title}/get_search")
    public JsonResult<PageInfo<Good>> getSearchList(@PathVariable("title") String title) {
        List<Good> goods = goodService.selectSearchGoods(title);
        PageInfo<Good> data = new PageInfo<Good>(goods);
        return new JsonResult<PageInfo<Good>>(OK, data);
    }

    @RequestMapping("{categoryId}/get_class")
    public JsonResult<PageInfo<Good>> getClassList(@PathVariable("categoryId") Integer categoryId) {
        List<Good> goods = goodService.selectClassGoods(categoryId);
        PageInfo<Good> data = new PageInfo<Good>(goods);
        return new JsonResult<PageInfo<Good>>(OK, data);
    }

    @RequestMapping("{categoryId}/get_rand")
    public JsonResult<List<Good>> getRandList(@PathVariable("categoryId") Integer categoryId) {
        List<Good> data = goodService.selectRandGoods(categoryId);
        return new JsonResult<List<Good>>(OK, data);
    }

    @GetMapping("{gid}/details")
    public JsonResult<Good> getById(@PathVariable("gid") Integer gid) {
        // 调用业务对象执行获取数据
        Good data = goodService.selectGoodById(gid);
        // 返回成功和数据
        return new JsonResult<Good>(OK, data);
    }

    @RequestMapping("sell")
    public JsonResult<Void> sellEquipment(Integer wid, Integer categoryId, String goodType,Double price, HttpSession session) {
        // 调用业务对象执行获取数据
        Integer uid = getUidFromSession(session);
        goodService.sellEquipment(uid,wid,categoryId,goodType,price);
        // 返回成功和数据
        return new JsonResult<Void>(OK);
    }
}
