package com.spark.bipay.constant;

public enum CoinType {
    Bitcoin("0","BTC"),
    Litecoin("2","LTC"),
    Dogecoin("3","DOGE"),
    Ethereum("60","ETH"),
    EthereumClassic("61","ETC"),
    Ripple("144","XRP"),
    Bitcoincash("145","BCH"),
    EOS("195","EOS"),
    TRX("196","TRX"),
    NEO("888","NEO");

    private String code;
    private String unit;

    CoinType(String code, String unit){
        this.code=code;
        this.unit=unit;
    }

    public String getCode(){
        return this.code;
    }

    public String getUnit(){
        return this.unit;
    }

    public static CoinType codeOf(int code){
        switch (code){
            case 0: return Bitcoin;
            case 60: return Ethereum;
        }
        return null;
    }
}
