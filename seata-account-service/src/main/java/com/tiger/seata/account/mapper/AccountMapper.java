package com.tiger.seata.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.seata.account.model.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:27
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
