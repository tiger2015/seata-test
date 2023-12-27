package com.tiger.seata.business.service.impl;

import com.tiger.seata.business.api.AccountFeign;
import com.tiger.seata.business.api.OrderFeign;
import com.tiger.seata.business.api.StockFeign;
import com.tiger.seata.business.model.Order;
import com.tiger.seata.business.service.BusinessService;
import com.tiger.seata.common.exception.BusinessException;
import com.tiger.seata.common.ret.R;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zenghu
 * @Date 2023年12月19日 20:51
 * @Description
 * @Version: 1.0
 **/
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private AccountFeign accountFeign;

    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private StockFeign stockFeign;

    @GlobalTransactional(rollbackFor = {Exception.class})
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        final R<Void> deduct = stockFeign.deduct(commodityCode, orderCount);
        if (deduct.getCode() != 200) {
            throw new BusinessException(400, "扣减库存失败");
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setAmount(orderCount * 5.0);
        final R<Integer> orderId = orderFeign.create(order);
        if (orderId.getCode() != 200) {
            throw new BusinessException(400, "创建订单失败");
        }
        final R<Void> debit = accountFeign.debit(userId, order.getAmount());
        if (debit.getCode() != 200) {
            throw new BusinessException(400, "账户扣减金额失败");
        }
//        if (order.getAmount() > 5){
//            throw new BusinessException(400, "订单错误");
//        }
    }
}
