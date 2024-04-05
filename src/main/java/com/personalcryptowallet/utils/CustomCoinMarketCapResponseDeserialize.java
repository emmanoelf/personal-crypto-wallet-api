package com.personalcryptowallet.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalcryptowallet.dto.coinMarketCap.CoinDto;
import com.personalcryptowallet.dto.coinMarketCap.CoinMarketCapResponseDto;

import java.io.IOException;
import java.util.Map;

public class CustomCoinMarketCapResponseDeserialize extends JsonDeserializer<CoinMarketCapResponseDto> {

    @Override
    @SuppressWarnings("unchecked")
    public CoinMarketCapResponseDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();
        CoinMarketCapResponseDto responseDto = new CoinMarketCapResponseDto();
        JsonNode jsonNode = jsonParser.readValueAsTree();
        Map<String, Object> map = objectMapper.convertValue(jsonNode.get("data"), Map.class);

        for (String key : map.keySet()) {
            responseDto.getData().add(objectMapper.convertValue(map.get(key), CoinDto.class));
        }

        return responseDto;
    }
}
