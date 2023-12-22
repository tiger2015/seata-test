package com.tiger.seata.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:40
 * @Description
 * @Version: 1.0
 **/
@SpringBootApplication
@ComponentScans({
        @ComponentScan(value = {"com.tiger.seata.common"})
})
@EnableDiscoveryClient
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
