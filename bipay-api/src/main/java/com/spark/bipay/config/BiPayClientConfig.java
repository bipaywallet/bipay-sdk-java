package com.spark.bipay.config;

import com.spark.bipay.http.client.BiPayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BiPayClientConfig {
    private String merchantId = "100000";
    private String merchantKey = "1234567";
    private String host = "http://127.0.0.1";

    @Bean
    public BiPayClient setBiPayClient(){
        BiPayClient client = new BiPayClient(host,merchantId,merchantKey);
        return client;
    }
}
