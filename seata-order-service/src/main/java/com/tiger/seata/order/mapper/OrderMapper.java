package com.tiger.seata.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.seata.order.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:22
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    int insert(@Param("order") Order order);
}
