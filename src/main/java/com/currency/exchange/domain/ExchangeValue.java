package com.currency.exchange.domain;

import jdk.jfr.DataAmount;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeValue {
    private long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private int port;

    public ExchangeValue(long id, String from, String to, BigDecimal conversionFactor) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
    }
}
