package com.suey.coin.controller;

import com.suey.coin.config.exception.BadRequestException;
import com.suey.coin.model.request.RequestDTO;
import com.suey.coin.model.request.ResponseDTO;
import com.suey.coin.service.ICoinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coins")
@Tag(name = "Coins")
@RequiredArgsConstructor
public class CoinController {

    private final ICoinService service;

    @GetMapping("/convert")
    @Operation(description = "Converts a value from one currency to another.")
    public ResponseDTO coinConverter(@Valid final RequestDTO request) throws BadRequestException {
        return service.coinConverter(request);
    }

    @GetMapping("/values")
    @Operation(description = "Returns a list of all available currencies.")
    public List<String> getAllCurrencies() {
        return service.getAllCurrencies();
    }

}