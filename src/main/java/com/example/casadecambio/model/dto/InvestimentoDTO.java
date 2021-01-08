package com.example.casadecambio.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InvestimentoDTO {

    private Long id;
    private BigDecimal valorInvestido;
    private BigDecimal quantidadeInvestida;
    private BigDecimal lucro;
    private String cpf;

    public InvestimentoDTO() {
    }

    public InvestimentoDTO(BigDecimal valorInvestido, BigDecimal quantidadeInvestida, BigDecimal lucro, String cpf) {
        this.valorInvestido = valorInvestido.setScale(3, HALF_EVEN);
        this.quantidadeInvestida = quantidadeInvestida;
        this.lucro = lucro.setScale(3, HALF_EVEN);
        this.cpf = cpf;
    }

}
