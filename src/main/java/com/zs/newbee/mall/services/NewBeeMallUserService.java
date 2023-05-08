package com.zs.newbee.mall.services;

import com.zs.newbee.mall.api.mall.param.MallUserUpdateParam;

public interface NewBeeMallUserService {

    /**
     * 用户注册
     * @param loginName
     * @param password
     * @return
     */
    String register(String loginName, String password);

    /**
     * 用户登录
     * @param loginName
     * @param passwordMD5
     * @return
     */
    String login(String loginName, String passwordMD5);

    /**
     * 退出登录
     * @param userId
     * @return
     */
    Boolean logout(Long userId);
}
