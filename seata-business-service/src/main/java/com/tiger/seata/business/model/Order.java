package com.tiger.seata.business.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Zenghu
 * @Date 2023年12月17日 16:19
 * @Description
 * @Version: 1.0
 **/
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 4049178889955450103L;

    private Integer id;

    private String orderNo;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Double amount;

}
