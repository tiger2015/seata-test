package com.tiger.seata.order.controller;

import com.tiger.seata.common.ret.R;
import com.tiger.seata.order.model.Order;
import com.tiger.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:23
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public R<Integer> create(@RequestBody Order order) {
        int id = orderService.create(order);
        return R.success(id);
    }

}
