package com.suey.coin.model.crypto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinDTO {

    @JsonProperty("uuid")
    private Long id;

    private String symbol;

    private String name;

    private BigDecimal price;

    @JsonProperty("24hVolume")
    private String volume24h;

}