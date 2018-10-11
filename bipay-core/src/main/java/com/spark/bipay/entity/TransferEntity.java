package com.spark.bipay.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferEntity {

    //商户号
    private String merchantId ;
    //转账地址
    private String address ;
    //币种类型
    private int coinType ;
    //转账数量
    private BigDecimal amount ;
    //转账回调地址
    private String callUrl ;
    //提币申请单号
    private String businessId ;
}
