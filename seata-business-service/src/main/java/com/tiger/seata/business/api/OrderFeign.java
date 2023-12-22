package com.tiger.seata.business.api;

import com.tiger.seata.business.model.Order;
import com.tiger.seata.common.ret.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 22:48
 * @Description
 * @Version: 1.0
 **/
@FeignClient(value = "order-service", path = "/order")
public interface OrderFeign {
    @PostMapping(value = "/create", consumes ="application/json" )
    R<Integer> create(@RequestBody Order order);
}
