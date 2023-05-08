package com.zs.newbee.mall;

import com.zs.newbee.mall.services.NewBeeMallUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest         //注意这里需要添加注解，否则会出现错误
public class MallUserTests {

    @Autowired
    private NewBeeMallUserService service;

    @Test
    public void registerUser(){
        String result = service.register("zsfq","12345678");
        System.out.println(result);
    }
}
