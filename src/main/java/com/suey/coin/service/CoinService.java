package com.suey.coin.service;

import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.enums.EnumCoin;
import com.suey.coin.model.request.RequestDTO;
import com.suey.coin.model.request.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class CoinService implements ICoinService {

    public ResponseDTO coinConverter(final RequestDTO request) throws BadRequestException {
        return null;
    }

    public List<String> getAllCurrencies() {
        return stream(EnumCoin.values())
                .map(EnumCoin::name)
                .distinct()
                .sorted()
                .toList();
    }

}