package com.suey.coin.model.crypto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsDTO {

    private Long total;

    private Long totalCoins;

    private Long totalMarkets;

    private Long totalExchanges;

    private String totalMarketCap;

    private String total24hVolume;

}