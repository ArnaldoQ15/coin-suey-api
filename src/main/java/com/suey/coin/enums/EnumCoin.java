package com.suey.coin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Getter
@AllArgsConstructor
public enum EnumCoin {

    // CURRENCIES
    ARGENTINE_PESO("ARS", FALSE),
    AUSTRALIAN_DOLLAR("AUD", FALSE),
    AMERICAN_DOLLAR("USD", FALSE),
    BRITISH_POUND("GBP", FALSE),
    BRAZILIAN_REAL("BRL", FALSE),
    CANADIAN_DOLLAR("CAD", FALSE),
    CHINESE_YUAN("CNY", FALSE),
    EURO("EUR", FALSE),
    HONG_KONG_DOLLAR("HKD", FALSE),
    JAPANESE_YEN("JPY", FALSE),
    MEXICAN_PESO("MXN", FALSE),
    RUSSIAN_RUBLE("RUB", FALSE),
    SINGAPORE_DOLLAR("SGD", FALSE),
    SWEDISH_KRONA("SEK", FALSE),
    SWISS_FRANC("CHF", FALSE),
    TURKISH_LIRA("TRY", FALSE),

    // CRYPTO
    BITCOIN("Qwsogvtv82FCd", TRUE),
    BITCOIN_CASH("ZlZpzOJo43mIo", TRUE),
    BINANCE_COIN("WcwrkfNI4FUAe", TRUE),
    BINANCE_USD("vSo2fu9iE1s0Y", TRUE),
    CARDANO("qzawljRxB5bYu", TRUE),
    DOGECOIN("a91GCGd_u96cF", TRUE),
    ETHEREUM("razxDUgYGNAdQ", TRUE),
    ETHEREUM_CLASSIC("hnfQfsYfeIGUQ", TRUE),
    LITECOIN("D7B1x_ks7WhV5", TRUE),
    MONERO("3mVx2FX_iJFp5", TRUE),
    RIPPLE("-l8Mn2pVlRs-p", TRUE),
    SOLANA("zNZHO_Sjf", TRUE),
    STELLAR("f3iaFeCKEmkaZ", TRUE),
    TETHER("HIVsRcGKkPFtW", TRUE),
    TRON("qUhEFk1I61atv", TRUE),
    VECHAIN("FEbS54wxo4oIl", TRUE);

    private final String code;
    private final Boolean isCrypto;

}