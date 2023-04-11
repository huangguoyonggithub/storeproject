package com.hgy.storeproject.controller;

import com.hgy.storeproject.entity.Collect;
import com.hgy.storeproject.service.ICartService;
import com.hgy.storeproject.service.ICollectService;
import com.hgy.storeproject.util.JsonResult;
import com.hgy.storeproject.vo.CartVO;
import com.hgy.storeproject.vo.CollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController // @Controller + @ResponseBody //表示此方法的响应结果以json格式进行数据的响应给到前端
@RequestMapping("collects")
public class CollectController extends BaseController{
    @Autowired
    private ICollectService collectService;

    @RequestMapping("{gid}/add_to_collect")
    public JsonResult<Void> addToCollect(@PathVariable("gid")Integer gid,HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行添加到购物车
        collectService.addToCollect(gid,uid,username);
        // 返回成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<CollectVO>> getCollectByUid(HttpSession session) {
        // 从Session中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行查询数据
        List<CollectVO> data = collectService.getCollectVOByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<CollectVO>>(OK, data);
    }

    @RequestMapping("{tid}/delete_collect")
    public JsonResult<Void> DeleteCollect(@PathVariable("tid") Integer tid) {
        // 调用业务对象执行添加到购物车
        collectService.deleteCollectByTid(tid);
        // 返回成功
        return new JsonResult<Void>(OK);
    }
}
