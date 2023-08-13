package com.suey.coin.model.request;

import com.suey.coin.enums.EnumCoin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private ResponseDataDTO from;
    private ResponseDataDTO to;
    private LocalDateTime dateTime;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseDataDTO {

        private EnumCoin coin;
        private BigDecimal amount;

    }

}