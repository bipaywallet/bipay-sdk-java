package com.spark.bipay.controller;


import com.spark.bipay.constant.CoinType;
import com.spark.bipay.entity.Address;
import com.spark.bipay.entity.Transaction;
import com.spark.bipay.http.ResponseMessage;
import com.spark.bipay.service.BiPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@RestController
public class RequestController {
    @Autowired
    private BiPayService biPayService;

    /**
     * 创建新地址
     * @param coinType
     * @return
     */
    @RequestMapping("/bipay/create-address")
    public Address createCoinAddress(int coinType){
        return biPayService.createCoinAddress(CoinType.codeOf(coinType));
    }

    /**
     * 发起转账请求
     * @param coinType
     * @param amount
     * @param address
     * @return
     */
    @RequestMapping("/bipay/transfer")
    public ResponseMessage<String> transfer(int coinType,BigDecimal amount,String address){
        String orderId = String.valueOf(Calendar.getInstance().getTimeInMillis());
        CoinType coin = CoinType.codeOf(coinType);
        ResponseMessage<String> resp = biPayService.transfer(orderId, amount,coin,coin.getCode(),address);
        return resp;
    }

    @RequestMapping("/bipay/transaction")
    public List<Transaction> queryTransaction() throws Exception {
        return biPayService.queryTransaction();
    }
}
