package com.zs.newbee.mall.utils;

public class NumberUtil {

    public static boolean isPhoneNumber(String phoneNumber){
        String phoneRegex = "[1][3578]\\d{9}";
        //"[1]"代表第一位为数字1，"[3578]"表示第二位可以为3，5，7，8中的一个，"\\d{9}"代表后面是可以0~9的数字，有9位
        if(phoneNumber.isEmpty()){
            return false;
        }else{
            return phoneNumber.matches(phoneRegex);
        }
    }
}
