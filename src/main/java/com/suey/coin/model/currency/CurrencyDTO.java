package com.suey.coin.model.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDTO {

    private String status;

    @JsonProperty("updated_date")
    private LocalDate updatedDate;

    @JsonProperty("base_currency_code")
    private String baseCurrencyCode;

    @JsonProperty("base_currency_name")
    private String baseCurrencyName;

    private BigDecimal amount;

    private Map<String, CurrencyDataDTO> rates;

}