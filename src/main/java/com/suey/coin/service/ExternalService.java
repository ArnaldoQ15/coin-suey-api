package com.suey.coin.service;

import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.enums.EnumCoin;
import com.suey.coin.model.crypto.CoinDTO;
import com.suey.coin.model.crypto.CoinDataDTO;
import com.suey.coin.model.currency.CurrencyDTO;
import com.suey.coin.model.currency.CurrencyDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ExternalService implements IExternalService {

    private static final String URL_CONVERT_CURRENCY = "https://api.getgeoapi.com/v2/currency/convert?" +
            "api_key={apiKey}&from={from}&to={to}&amount={amount}&format=json";
    private static final String URL_CHECK_CRYPTO = "https://api.coinranking.com/v2/coin/{from}/price";
    private static final String ERROR_CURRENCY_NOT_AVAILABLE = "error.currency-not-available";

    @Value("${key.currency.geo.api}")
    private String keyGeoApi;

    public BigDecimal convertCurrency(final EnumCoin from, final BigDecimal amount, final EnumCoin to) throws BadRequestException {
        final RestTemplate restTemplate = new RestTemplate();
        final Map<String, String> map = new HashMap<>();
        map.put("from", from.getCode());
        map.put("apiKey", keyGeoApi);
        map.put("to", to.getCode());
        map.put("amount", amount.toString());

        try {
            final CurrencyDTO response = restTemplate.getForObject(URL_CONVERT_CURRENCY, CurrencyDTO.class, map);

            return ofNullable(response)
                    .map(CurrencyDTO::getRates)
                    .map(rates -> rates.get(to.getCode()))
                    .map(CurrencyDataDTO::getRateForAmount)
                    .orElseThrow(() -> new BadRequestException(ERROR_CURRENCY_NOT_AVAILABLE, from.getCode()));
        } catch (final Exception e) {
            throw new BadRequestException(ERROR_CURRENCY_NOT_AVAILABLE, from.getCode());
        }
    }

    public BigDecimal getCriptoPrice(final EnumCoin coin) throws BadRequestException {
        final RestTemplate restTemplate = new RestTemplate();
        final Map<String, String> map = new HashMap<>();
        map.put("from", coin.getCode());

        try {
            final CoinDTO response = restTemplate.getForObject(URL_CHECK_CRYPTO, CoinDTO.class, map);

            return ofNullable(response)
                    .map(CoinDTO::getData)
                    .map(CoinDataDTO::getPrice)
                    .orElseThrow(() -> new BadRequestException(ERROR_CURRENCY_NOT_AVAILABLE, coin.getCode()));
        } catch (final Exception e) {
            throw new BadRequestException(ERROR_CURRENCY_NOT_AVAILABLE, coin.getCode());
        }
    }

}