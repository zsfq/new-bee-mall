package com.zs.newbee.mall;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class NewbeeMallApiApplicationTests {
    @Resource
    private DataSource defaultDataSource;

    @Test
    public void datasourceTest() throws SQLException {
        Connection connection = defaultDataSource.getConnection();
        System.out.println("获取连接");
        //判断连接对象是否为空
        System.out.println(connection != null);
        connection.close();
    }
    @Test
    void contextLoads() {
    }

}
