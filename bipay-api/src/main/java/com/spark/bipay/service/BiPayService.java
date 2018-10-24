package com.spark.bipay.service;

import com.spark.bipay.constant.CoinType;
import com.spark.bipay.entity.Address;
import com.spark.bipay.entity.Transaction;
import com.spark.bipay.http.ResponseMessage;
import com.spark.bipay.http.client.BiPayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BiPayService {
    @Autowired
    private BiPayClient biPayClient;
    @Value("${server.host}")
    private String host;
    @Value("#{'${bipay.supported-coins}'.split(',')}")
    private List<String> supportedCoins;

    public boolean isSupportedCoin(String coinName){
        return  supportedCoins!=null && supportedCoins.contains(coinName);
    }

    /**
     * 创建币种地址
     * @param coinType
     * @return
     */
    public Address createCoinAddress(CoinType coinType){
        String callbackUrl = host + "/bipay/notify";
        try {
            ResponseMessage<Address> resp =  biPayClient.createCoinAddress(coinType.getCode(), callbackUrl);
            return  resp.getData();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public ResponseMessage<String> transfer(String orderId, BigDecimal amount,CoinType coinType,String subCoinType,String address){
        String callbackUrl = host + "/bipay/notify";
        try {
            ResponseMessage<String> resp =  biPayClient.transfer(orderId,amount,coinType.getCode(),subCoinType,address,callbackUrl);
            return resp;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseMessage.error("提交转币失败");
    }

    public List<Transaction> queryTransaction() throws Exception {
        return biPayClient.queryTransaction();
    }
}
