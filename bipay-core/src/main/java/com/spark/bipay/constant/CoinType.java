package com.spark.bipay.constant;

public enum CoinType {
    BTC(0,"BTC","Bitcoin"),
    ETH(60,"ETH","Ethereum"),
    DVC(206,"DVC","DevCoin"),
    USDT(207,"USDT","USDT"),
    CTGC(60000010,"CTGC","CTGC"),
    GIP(60000011,"GIP","GIP");

    private int code;
    private String unit;
    private String name;

    CoinType(int code,String unit,String name){
        this.code=code;
    }

    public int getCode(){
        return this.code;
    }

    public static CoinType codeOf(int code){
        switch (code){
            case 0: return BTC;
            case 60: return ETH;
            case 206: return DVC;
            case 207: return USDT;
            case 60000010: return CTGC;
            case 60000011: return GIP;
        }
        return null;
    }
}
