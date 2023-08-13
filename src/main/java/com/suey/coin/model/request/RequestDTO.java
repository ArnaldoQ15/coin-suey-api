package com.suey.coin.model.request;

import com.suey.coin.enums.EnumCoin;
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
public class RequestDTO {

    private EnumCoin from;

    private EnumCoin to;

    private BigDecimal amount;

}