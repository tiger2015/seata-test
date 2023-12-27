package com.tiger.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 21:12
 * @Description
 * @Version: 1.0
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScans({
        @ComponentScan(value = {"com.tiger.seata.common"})
})
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.tiger.seata.account.mapper"})
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
