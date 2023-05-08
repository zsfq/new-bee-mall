package com.zs.newbee.mall.services.impl;

import com.zs.newbee.mall.common.Constants;
import com.zs.newbee.mall.common.ServiceResultEnum;
import com.zs.newbee.mall.dao.MallUserMapper;
import com.zs.newbee.mall.entity.MallUser;
import com.zs.newbee.mall.services.NewBeeMallUserService;
import com.zs.newbee.mall.utils.MD5Util;
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
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        MallUser registerUser = new MallUser();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);
        registerUser.setIntroduceSign(Constants.USER_INTRO);

        //TODO：密码采用MD5方式，可以改进增加安全性
        String passwordMD5 = MD5Util.MD5Encode(password,"UTF-8");
        registerUser.setPasswordMd5(passwordMD5);
        if(mallUserMapper.insertSelective(registerUser) > 0){
            return ServiceResultEnum.SUCCEESS.getResult();
        }
        return ServiceResultEnum.ERROR.getResult();
    }

    @Override
    public String login(String loginName, String passwordMD5) {
        return null;
    }

    @Override
    public Boolean logout(Long userId) {
        return null;
    }
}
