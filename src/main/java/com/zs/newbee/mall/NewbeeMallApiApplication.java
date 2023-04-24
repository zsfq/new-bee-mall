package com.zs.newbee.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zs.newbee.mall.dao")     //Mapper接口的位置
public class NewbeeMallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewbeeMallApiApplication.class, args);
    }

}
