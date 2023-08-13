package com.suey.coin.service;

import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.model.request.RequestDTO;
import com.suey.coin.model.request.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoinService implements ICoinService {

    public ResponseDTO coinConverter(final RequestDTO request) throws BadRequestException {
        return null;
    }

}