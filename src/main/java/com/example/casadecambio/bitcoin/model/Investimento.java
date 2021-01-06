package com.example.casadecambio.bitcoin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "INVESTIMENTOS")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private BigDecimal valorInvestido;

    private BigDecimal quantidadeInvestida;

    private BigDecimal lucro;

    private LocalDateTime dataDoInvestimento;

    private BigDecimal cotacaoAtualBitcoin;

    private String cpf;

    public Investimento() {
    }

    public Investimento(String tipo, BigDecimal valorInvestido, BigDecimal quantidadeInvestida, BigDecimal lucro, LocalDateTime dataDoInvestimento, BigDecimal cotacaoAtualBitcoin, String cpf) {
        this.tipo = tipo;
        this.valorInvestido = valorInvestido;
        this.quantidadeInvestida = quantidadeInvestida;
        this.lucro = lucro;
        this.dataDoInvestimento = dataDoInvestimento;
        this.cotacaoAtualBitcoin = cotacaoAtualBitcoin;
        this.cpf = cpf;
    }
}
