package com.xunru.chattingroom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//扫描controller和service层
@ComponentScan(value = {"com.xunru.controller","com.xunru.service","com.xunru.core"})
//扫描mapper,可在mapper接口中添加@Mapper的注解，两者二选一即可
@MapperScan(basePackages = "com.xunru.dao")
public class ChattingroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChattingroomApplication.class, args);
    }

}
