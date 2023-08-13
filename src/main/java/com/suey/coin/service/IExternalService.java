package com.suey.coin.service;


import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.enums.EnumCoin;

import java.math.BigDecimal;

public interface IExternalService {

    BigDecimal convertCurrency(final EnumCoin from, final BigDecimal amount, final EnumCoin to) throws BadRequestException;

    BigDecimal getCriptoPrice(final EnumCoin coin) throws BadRequestException;

}