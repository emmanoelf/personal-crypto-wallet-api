package com.personalcryptowallet.client;

import com.personalcryptowallet.config.FeignClientConfiguration;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CoinMarketCapClient", url = "https://pro-api.coinmarketcap.com/v1", configuration = FeignClientConfiguration.class)
public interface CoinMarketCapClient {

    @GetMapping("/cryptocurrency/quotes/latest")
    CoinMarketCapResponseDto getCoin(@RequestParam String slug);
}
