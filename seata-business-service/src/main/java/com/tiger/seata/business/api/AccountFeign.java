package com.tiger.seata.business.api;

import com.tiger.seata.common.ret.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 22:48
 * @Description
 * @Version: 1.0
 **/
@FeignClient(value = "account-service", path = "/account")
public interface AccountFeign {

    @PostMapping("/debit")
    R<Void> debit(@RequestParam(value = "userId") String userId, @RequestParam(value = "money") Double money);
}
