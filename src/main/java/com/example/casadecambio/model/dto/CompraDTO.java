package com.example.casadecambio.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompraDTO {

    private Long id;
    private BigDecimal quantidadeDeBitcoins;
    private BigDecimal valorDaCompra;
    private String cpf;

    public CompraDTO() {
    }

    public CompraDTO(BigDecimal quantidadeDeBitcoins, BigDecimal valorDaCompra, String cpf) {
        this.quantidadeDeBitcoins = quantidadeDeBitcoins;
        this.valorDaCompra = valorDaCompra.setScale(3, RoundingMode.HALF_UP);
        this.cpf = cpf;
    }
}
