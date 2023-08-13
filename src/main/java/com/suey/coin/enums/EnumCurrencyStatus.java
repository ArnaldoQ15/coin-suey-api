package com.suey.coin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumCurrencyStatus {

    SUCCESS("success"),
    FAIL("fail");

    private final String description;

}