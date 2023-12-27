package com.tiger.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.seata.order.mapper.OrderMapper;
import com.tiger.seata.order.model.Order;
import com.tiger.seata.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 20:32
 * @Description
 * @Version: 1.0
 **/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    //@Transactional(rollbackFor = {Exception.class})
    @Override
    public int create(Order order) {
        getBaseMapper().insert(order);
        log.info("order id:{}", order.getId());
        return order.getId();
    }
}
