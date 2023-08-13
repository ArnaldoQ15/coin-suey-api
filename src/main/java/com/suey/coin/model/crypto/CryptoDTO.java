package com.suey.coin.model.crypto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CryptoDTO {

    private StatsDTO stats;

    private List<CoinDTO> coins;

}