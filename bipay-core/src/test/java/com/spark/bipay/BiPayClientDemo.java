package com.spark.bipay;

import com.spark.bipay.constant.CoinType;
import com.spark.bipay.entity.Address;
import com.spark.bipay.http.ResponseMessage;
import com.spark.bipay.http.client.BiPayClient;

public class BiPayClientDemo {

    public static void main(String[] args) throws Exception {
        BiPayClient client = new BiPayClient("http://47.52.142.109","100067","96f08a865a070c605426854283c32caf");
        ResponseMessage<Address> resp = client.requestCoinAddress(CoinType.BTC,"http://47.52.142.109/callback.html");
        System.out.println(resp.getMessage());
        Address address = resp.getData();

        System.out.println(address.getAddress());
    }
}
