package com.example.casadecambio.bitcoin.model;

import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Data {

    private String amount;

    private String currency;

    private String base;

    public Data() {
    }

    public Data(String amount, String currency, String base) {
        this.amount = amount;
        this.currency = currency;
        this.base = base;
    }
}
