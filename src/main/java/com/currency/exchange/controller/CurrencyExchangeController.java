package com.currency.exchange.controller;

import com.currency.exchange.domain.ExchangeValue;
import com.currency.exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        return new ResponseEntity<>(currencyExchangeService.getExchangeInfoWithId(from, to), HttpStatus.OK);
    }
}
