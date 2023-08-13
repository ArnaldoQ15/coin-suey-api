package com.suey.coin.service;

import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.enums.EnumCoin;
import com.suey.coin.model.request.RequestDTO;
import com.suey.coin.model.request.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static com.suey.coin.enums.EnumCoin.AMERICAN_DOLLAR;
import static com.suey.coin.enums.EnumCoin.values;
import static java.lang.Boolean.FALSE;
import static java.math.RoundingMode.HALF_DOWN;
import static java.time.LocalDateTime.now;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

@Service
@RequiredArgsConstructor
public class CoinService implements ICoinService {

    private final IExternalService externalService;
    private static final MathContext PRECISION = new MathContext(10, HALF_DOWN);

    public ResponseDTO coinConverter(final RequestDTO request) throws BadRequestException {
        if (isTrue(isCriptoFrom(request)) && isTrue(isCriptoTo(request))) {
            return convertCriptoToCripto(request);
        }

        else if (isTrue(isCriptoFrom(request)) && isFalse(isCriptoTo(request))) {
            return convertCriptoToCurrency(request);
        }

        else if (isFalse(isCriptoFrom(request)) && isTrue(isCriptoTo(request))) {
            return convertCurrencyToCripto(request);
        }

        else if (isFalse(isCriptoFrom(request)) && isFalse(isCriptoTo(request))) {
            return convertCurrencyToCurrency(request);
        }

        else {
            throw new BadRequestException("error.valid-currency");
        }
    }

    private ResponseDTO getResponseDTO(final RequestDTO request, final BigDecimal finalValue) {
        return ResponseDTO.builder()
                .from(
                        ResponseDTO.ResponseDataDTO.builder()
                                .coin(request.getFrom())
                                .amount(request.getAmount())
                                .build())
                .to(
                        ResponseDTO.ResponseDataDTO.builder()
                                .coin(request.getTo())
                                .amount(finalValue)
                                .build())
                .dateTime(now())
                .build();
    }

    private ResponseDTO convertCriptoToCripto(final RequestDTO request) throws BadRequestException {
        final BigDecimal criptoPriceFrom = externalService.getCriptoPrice(request.getFrom());
        final BigDecimal criptoPriceDollarFrom = request.getAmount().multiply(criptoPriceFrom, PRECISION);
        final BigDecimal criptoPriceTo = externalService.getCriptoPrice(request.getTo());
        final BigDecimal finalPrice = criptoPriceDollarFrom.divide(criptoPriceTo, PRECISION);
        return getResponseDTO(request, finalPrice);
    }

    private ResponseDTO convertCriptoToCurrency(final RequestDTO request) throws BadRequestException {
        final BigDecimal criptoPriceFrom = externalService.getCriptoPrice(request.getFrom());
        final BigDecimal criptoPriceDollarFrom = request.getAmount().multiply(criptoPriceFrom, PRECISION);
        final BigDecimal convertedValue =
                externalService.convertCurrency(AMERICAN_DOLLAR, criptoPriceDollarFrom, request.getTo());
        return getResponseDTO(request, convertedValue);
    }

    private ResponseDTO convertCurrencyToCripto(final RequestDTO request) throws BadRequestException {
        final BigDecimal amountInDollar =
                externalService.convertCurrency(request.getFrom(), request.getAmount(), AMERICAN_DOLLAR);
        final BigDecimal criptoPriceTo = externalService.getCriptoPrice(request.getTo());
        final BigDecimal finalValue = amountInDollar.divide(criptoPriceTo, PRECISION);
        return getResponseDTO(request, finalValue);
    }

    private ResponseDTO convertCurrencyToCurrency(final RequestDTO request) throws BadRequestException {
        final BigDecimal finalValue = externalService.convertCurrency(request.getFrom(), request.getAmount(), request.getTo());
        return getResponseDTO(request, finalValue);
    }

    private Boolean isCriptoFrom(final RequestDTO request) {
        return ofNullable(request.getFrom())
                .map(EnumCoin::getIsCrypto)
                .orElse(FALSE);
    }

    private Boolean isCriptoTo(final RequestDTO request) {
        return ofNullable(request.getTo())
                .map(EnumCoin::getIsCrypto)
                .orElse(FALSE);
    }

    public List<String> getAllCurrencies() {
        return stream(values())
                .map(EnumCoin::name)
                .distinct()
                .sorted()
                .toList();
    }

}