package com.example.casadecambio.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.math.RoundingMode.HALF_EVEN;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InvestimentoDTO {

    private Long id;
    private String tipo;
    private BigDecimal valorInvestido;
    private BigDecimal quantidadeInvestida;
    private BigDecimal lucro;
    private LocalDateTime dataDoInvestimento;
    private BigDecimal cotacaoAtualBitcoin;
    private String cpf;

    public InvestimentoDTO() {
        this.dataDoInvestimento = dataDoInvestimento;
    }

    public InvestimentoDTO(String tipo, BigDecimal valorInvestido, BigDecimal quantidadeInvestida, BigDecimal lucro, LocalDateTime dataDoInvestimento, BigDecimal cotacaoAtualBitcoin, String cpf) {
        this.tipo = tipo;
        this.valorInvestido = valorInvestido.setScale(3, HALF_EVEN);
        this.quantidadeInvestida = quantidadeInvestida;
        this.lucro = lucro.setScale(3, HALF_EVEN);
        this.dataDoInvestimento = dataDoInvestimento;
        this.cotacaoAtualBitcoin = cotacaoAtualBitcoin.setScale(3, HALF_EVEN);
        this.cpf = cpf;
    }

}
