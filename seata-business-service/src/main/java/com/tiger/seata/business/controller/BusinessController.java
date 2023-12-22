package com.tiger.seata.business.controller;

import com.tiger.seata.business.service.BusinessService;
import com.tiger.seata.common.exception.BusinessException;
import com.tiger.seata.common.ret.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zenghu
 * @Date 2023年12月19日 20:57
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/purchase")
    public R<Void> purchase(@RequestParam("userId") String userId,
                            @RequestParam("commodityCode") String commodityCode,
                            @RequestParam("orderCount") Integer orderCount) throws BusinessException {
        businessService.purchase(userId, commodityCode, orderCount);
        return R.success();
    }
}
