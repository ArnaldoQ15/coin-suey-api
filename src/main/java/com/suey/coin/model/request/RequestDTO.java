package com.suey.coin.model.request;

import com.suey.coin.enums.EnumCoin;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private EnumCoin from;

    @NotNull
    private EnumCoin to;

    @NotNull
    private BigDecimal amount;

}