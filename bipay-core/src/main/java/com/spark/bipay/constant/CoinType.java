package com.spark.bipay.constant;

public enum CoinType {
    BTC(0,"BTC","Bitcoin"),
    ETH(60,"ETH","Ethereum"),
    DVC(206,"DVC","DevCoin");

    private int code;
    private String unit;
    private String name;

    CoinType(int code,String unit,String name){
        this.code=code;
    }

    public int getCode(){
        return this.code;
    }
}
