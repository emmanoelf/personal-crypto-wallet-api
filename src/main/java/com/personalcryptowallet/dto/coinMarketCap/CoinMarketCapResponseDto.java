package com.personalcryptowallet.dto.coinMarketCap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.personalcryptowallet.utils.CustomCoinMarketCapResponseDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CustomCoinMarketCapResponseDeserialize.class)
public class CoinMarketCapResponseDto {
    private List<CoinDto> data = new ArrayList<>();
}