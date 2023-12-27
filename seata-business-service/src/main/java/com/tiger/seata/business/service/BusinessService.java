package com.tiger.seata.business.service;

/**
 * @Author Zenghu
 * @Date 2023年12月19日 20:51
 * @Description
 * @Version: 1.0
 **/
public interface BusinessService {
    void purchase(String userId, String commodityCode, int orderCount);
}
