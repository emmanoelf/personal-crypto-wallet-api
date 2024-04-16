package com.personalcryptowallet.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    @Value("${api.key.coin-market-cap}")
    private String apiKeyCoinMarketCap;
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("X-CMC_PRO_API_KEY", apiKeyCoinMarketCap);
        };
    }
}
