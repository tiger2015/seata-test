package com.tiger.seata.stock.controller;

import com.tiger.seata.common.ret.R;
import com.tiger.seata.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:01
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/deduct")
    public R<Void> deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count) {
        stockService.deduct(commodityCode, count);
        return R.success();
    }
}
