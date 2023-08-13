package com.suey.coin.model.currency;

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
public class RateDTO {

    @JsonProperty("currency_name")
    private String name;

    @JsonProperty("rate_for_amount")
    private BigDecimal rateForAmount;

    private BigDecimal rate;

}