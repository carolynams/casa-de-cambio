package com.example.casadecambio.bitcoin.builder;

import com.example.casadecambio.bitcoin.model.Data;

public class DataBuilder {
    private String amount;
    private String currency;
    private String base;

    public DataBuilder setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public DataBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public DataBuilder setBase(String base) {
        this.base = base;
        return this;
    }

    public Data createData() {
        return new Data(amount, currency, base);
    }
}