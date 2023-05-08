package com.zs.newbee.mall.dao;

import com.zs.newbee.mall.entity.MallUser;

public interface MallUserMapper {
    MallUser selectByLoginName(String loginName);

    int insertSelective(MallUser record);
}
