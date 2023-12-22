package com.tiger.seata.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiger.seata.stock.model.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 15:54
 * @Description
 * @Version: 1.0
 **/
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

  //   int deduceStock(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
