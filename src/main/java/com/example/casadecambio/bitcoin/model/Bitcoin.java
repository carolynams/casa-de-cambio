package com.example.casadecambio.bitcoin.model;

import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bitcoin {

    private Data data;

    public Bitcoin() {
    }

    public Bitcoin(Data data) {
        this.data = data;
    }
}
