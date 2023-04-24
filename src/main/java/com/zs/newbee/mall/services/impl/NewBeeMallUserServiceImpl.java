package com.zs.newbee.mall.services.impl;

import com.zs.newbee.mall.dao.MallUserMapper;
import com.zs.newbee.mall.entity.MallUser;
import com.zs.newbee.mall.services.NewBeeMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NewBeeMallUserServiceImpl implements NewBeeMallUserService {

    @Resource
    private MallUserMapper mallUserMapper;

    @Override
    public String register(String loginName, String password) {
        MallUser user = mallUserMapper.selectByLoginName(loginName);
        if(user != null){
            System.out.println("查询到数据啦");
            System.out.println(user.getUserId());
            System.out.println(user.getNickName());
            System.out.println(user.getLoginName());
        }
        return user.toString();
    }

    @Override
    public String login(String loginName, String passwordMD5) {
        return null;
    }
}
