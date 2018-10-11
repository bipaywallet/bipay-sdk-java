package com.spark.bipay.service;

import com.spark.bipay.constant.CoinType;
import com.spark.bipay.entity.Address;
import com.spark.bipay.http.ResponseMessage;
import com.spark.bipay.http.client.BiPayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiPayService {
    @Autowired
    private BiPayClient biPayClient;

    public Address createCoinAddress(CoinType coinType){
        String callbackUrl = biPayClient.getHost() + "/bipay/notify";
        try {
            ResponseMessage<Address> resp =  biPayClient.requestCoinAddress(coinType, callbackUrl);
            return  resp.getData();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
