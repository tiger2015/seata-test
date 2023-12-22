package com.tiger.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.seata.common.exception.BusinessException;
import com.tiger.seata.order.mapper.OrderMapper;
import com.tiger.seata.order.model.Order;
import com.tiger.seata.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 20:32
 * @Description
 * @Version: 1.0
 **/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Transactional(rollbackFor = {Exception.class, BusinessException.class})
    @Override
    public int create(Order order) throws BusinessException {
        getBaseMapper().insert(order);
        log.info("order id:{}", order.getId());
        if (order.getId() > 10){
            throw new BusinessException(400, "创建订单失败");
        }
        return order.getId();
    }
}
