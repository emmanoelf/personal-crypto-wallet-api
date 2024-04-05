package com.personalcryptowallet.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("X-CMC_PRO_API_KEY", "7ed90a6d-683f-45a8-8f40-beed275cb11a");
        };
    }
}
