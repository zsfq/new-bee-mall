package com.zs.newbee.mall.services;

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
}
