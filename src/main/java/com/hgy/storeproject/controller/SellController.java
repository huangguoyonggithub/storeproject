package com.hgy.storeproject.controller;

import com.github.pagehelper.PageInfo;
import com.hgy.storeproject.entity.Good;
import com.hgy.storeproject.entity.Sell;
import com.hgy.storeproject.service.IGoodService;
import com.hgy.storeproject.service.ISellService;
import com.hgy.storeproject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController // @Controller + @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
@RequestMapping("sells")
public class SellController extends BaseController{
    @Autowired
    private ISellService sellService;

    @RequestMapping({"/",""})
    public JsonResult<List<Sell>> getSellList(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Sell> data = sellService.selectAllSell(uid);
        return new JsonResult<List<Sell>>(OK, data);
    }
}
