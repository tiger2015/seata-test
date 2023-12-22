package com.tiger.seata.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.seata.stock.mapper.StockMapper;
import com.tiger.seata.stock.model.Stock;
import com.tiger.seata.stock.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 21:46
 * @Description
 * @Version: 1.0
 **/
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Transactional
    @Override
    public boolean deduct(String commodityCode, Integer count) {
        UpdateWrapper<Stock> wrapper = new UpdateWrapper<>();
        wrapper.setSql("count = count - " + count)
                .eq("commodity_code", commodityCode);
        return update(wrapper);
    }
}
