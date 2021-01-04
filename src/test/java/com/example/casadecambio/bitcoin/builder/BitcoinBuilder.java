package com.example.casadecambio.bitcoin.builder;

import com.example.casadecambio.bitcoin.model.Bitcoin;
import com.example.casadecambio.bitcoin.model.Data;

public class BitcoinBuilder {
    private Data data;

    public BitcoinBuilder setData(Data data) {
        this.data = data;
        return this;
    }

    public Bitcoin createBitcoin() {
        return new Bitcoin(data);
    }
}