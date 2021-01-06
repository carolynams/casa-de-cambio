package com.example.casadecambio.bitcoin.model;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@lombok.Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Data {

    private BigDecimal amount;

    private String currency;

    private String base;

    public Data() {
    }

    public Data(BigDecimal amount, String currency, String base) {
        this.amount = amount;
        this.currency = currency;
        this.base = base;
    }
}
