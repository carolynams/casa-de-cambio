package com.example.casadecambio.bitcoin.model.builder;

import com.example.casadecambio.bitcoin.model.Investimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvestimentoBuilder {
    private String tipo;
    private BigDecimal valorInvestido;
    private BigDecimal quantidadeInvestida;
    private BigDecimal lucro;
    private LocalDateTime dataDoInvestimento;
    private BigDecimal cotacaoAtualBitcoin;
    private String cpf;

    public InvestimentoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public InvestimentoBuilder setValorInvestido(BigDecimal valorInvestido) {
        this.valorInvestido = valorInvestido;
        return this;
    }

    public InvestimentoBuilder setQuantidadeInvestida(BigDecimal quantidadeInvestida) {
        this.quantidadeInvestida = quantidadeInvestida;
        return this;
    }

    public InvestimentoBuilder setLucro(BigDecimal lucro) {
        this.lucro = lucro;
        return this;
    }

    public InvestimentoBuilder setDataDoInvestimento(LocalDateTime dataDoInvestimento) {
        this.dataDoInvestimento = dataDoInvestimento;
        return this;
    }

    public InvestimentoBuilder setCotacaoAtualBitcoin(BigDecimal cotacaoAtualBitcoin) {
        this.cotacaoAtualBitcoin = cotacaoAtualBitcoin;
        return this;
    }

    public InvestimentoBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Investimento createInvestimento() {
        return new Investimento(tipo, valorInvestido, quantidadeInvestida, lucro, dataDoInvestimento, cotacaoAtualBitcoin, cpf);
    }
}