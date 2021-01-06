package com.example.casadecambio.bitcoin.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bitcoin {

    private Data data;

    public Bitcoin() {
    }

    public Bitcoin(Data data) {
        this.data = data;
    }
}
