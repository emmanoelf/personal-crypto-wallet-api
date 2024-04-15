package com.personalcryptowallet.dto.coinMarketCap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinDto {
    private Long id;
    private String symbol;
    private String slug;
    private QuoteDto quote;
}
