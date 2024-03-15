package com.currency.exchange.service;

import com.currency.exchange.domain.ExchangeValue;
import com.currency.exchange.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CurrencyExchangeService {
    @Autowired
    private Environment environment;
    @Autowired
    ExchangeValueRepository exchangeValueRepository;
    public ExchangeValue getExchangeInfoWithId(String from, String to){
        ExchangeValue byFromAndTo = exchangeValueRepository.findByFromAndTo(from, to);
        if(Objects.isNull(byFromAndTo)){
            throw new RuntimeException("Exchange Value is null");
        }
        byFromAndTo.setPort(Integer.valueOf(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        return byFromAndTo;
    }
}
