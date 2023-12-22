package com.tiger.seata.account.controller;

import com.tiger.seata.account.service.AccountService;
import com.tiger.seata.common.ret.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:28
 * @Description
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/debit")
    public R<Void> debit(@RequestParam(value = "userId") String userId, @RequestParam(value = "money") Double money) {
        accountService.debit(userId, money);
        return R.success();
    }
}
