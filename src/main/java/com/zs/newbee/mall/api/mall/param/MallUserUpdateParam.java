package com.zs.newbee.mall.api.mall.param;

import lombok.Data;

import java.io.Serializable;
@Data
public class MallUserUpdateParam implements Serializable {
    private String nickName;

    private String passwordMd5;

    private String introduceSign;
}
