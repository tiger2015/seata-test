package com.tiger.seata.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 22:46
 * @Description
 * @Version: 1.0
 **/
@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan(value = {"com.tiger.seata.common"})
})
@EnableDiscoveryClient
@EnableFeignClients
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
