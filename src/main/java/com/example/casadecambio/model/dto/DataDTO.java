package com.example.casadecambio.model.dto;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.RoundingMode;

@lombok.Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DataDTO {

    private BigDecimal amount;

    private String currency;

    private String base;

    public DataDTO() {
    }

    public DataDTO(BigDecimal amount, String currency, String base) {
        this.amount = amount.setScale(3, RoundingMode.HALF_UP);
        this.currency = currency;
        this.base = base;
    }
}
