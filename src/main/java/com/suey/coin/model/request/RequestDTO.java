package com.suey.coin.model.request;

import com.suey.coin.config.annotation.Needed;
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

    @Needed
    private EnumCoin from;

    @Needed
    private EnumCoin to;

    @Needed
    private BigDecimal amount;

}