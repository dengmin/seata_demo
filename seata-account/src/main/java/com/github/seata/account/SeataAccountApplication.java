package com.github.seata.account;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author dengmin
 * @Created 2020/4/24 15:32
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.github.seata.dao")
@ComponentScan({"com.github.seata.service","com.github.seata.account"})
public class SeataAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }
}
