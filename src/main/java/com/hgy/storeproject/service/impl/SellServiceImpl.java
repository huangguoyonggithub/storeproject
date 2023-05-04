package com.hgy.storeproject.service.impl;

import com.hgy.storeproject.entity.Sell;
import com.hgy.storeproject.entity.User;
import com.hgy.storeproject.mapper.SellMapper;
import com.hgy.storeproject.service.ISellService;
import com.hgy.storeproject.service.IUserService;
import com.hgy.storeproject.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements ISellService {

    @Autowired
    private SellMapper sellMapper;
    @Autowired
    private IUserService userService;

    @Override
    public List<Sell> selectAllSell(Integer uid) {
        User user = userService.getByUid(uid);
        if (user == null){
            throw new UserNotFoundException("无用户登录");
        }
        return sellMapper.selectAllSell(uid);
    }
}
