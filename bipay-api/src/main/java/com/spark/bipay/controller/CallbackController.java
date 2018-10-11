package com.spark.bipay.controller;

import com.alibaba.fastjson.JSONObject;
import com.spark.bipay.entity.Trade;
import com.spark.bipay.http.client.BiPayClient;
import com.spark.bipay.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CallbackController {
    @Autowired
    BiPayClient biPayClient;
    private Logger logger = LoggerFactory.getLogger(CallbackController.class);

    @RequestMapping("/bipay/notify")
    public String tradeCallback(@RequestParam("timestamp")String timestamp,
                                @RequestParam("nonce")String nonce,
                                @RequestParam("body")String body,
                                @RequestParam("sign")String sign) throws Exception {
        logger.info("timestamp:{},nonce:{},body:{},sign:{}",timestamp,nonce,body,sign);
        if(!HttpUtil.checkSign(biPayClient.getKey(),timestamp,nonce,body,sign)){
            return "error";
        }

        List<Trade> list = JSONObject.parseArray(body,Trade.class);
        //TODO 业务处理
        logger.info("trades:{}",list);
        return "success";
    }
}
