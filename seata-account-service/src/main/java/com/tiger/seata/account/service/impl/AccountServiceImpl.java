package com.tiger.seata.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.seata.account.mapper.AccountMapper;
import com.tiger.seata.account.model.Account;
import com.tiger.seata.account.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Zenghu
 * @Date 2023年12月18日 21:16
 * @Description
 * @Version: 1.0
 **/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Override
    @Transactional
    public boolean debit(String userId, Double money) {
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.setSql("amount = amount - " + money)
                .eq("user_id", userId);
        return update(wrapper);
    }
}
