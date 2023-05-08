package com.zs.newbee.mall.common;

public enum ServiceResultEnum {
    //公共部分
    ERROR("error"),
    SUCCEESS("success"),

    //登录注册
    SAME_LOGIN_NAME_EXIST("用户名已存在！"),
    LOGIN_NAME_NULL("请输入登录名！"),
    LOGIN_NAME_IS_NOT_PHONE("请输入正确的手机号!"),
    LOGIN_PASSWORD_NULL("请输入密码！"),
    LOGIN_VERIFY_CODE_NULL("请输入验证码！"),
    LOGIN_VERIFY_CODE_ERROR("验证码错误！");


    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult(){
        return this.result;
    }

    public void setResult(String result){
        this.result = result;
    }
}
