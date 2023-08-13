package com.suey.coin.service;


import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.model.request.RequestDTO;
import com.suey.coin.model.request.ResponseDTO;

public interface ICoinService {

    ResponseDTO coinConverter(final RequestDTO request) throws BadRequestException;

}