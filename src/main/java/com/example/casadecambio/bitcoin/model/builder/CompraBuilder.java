package com.example.casadecambio.bitcoin.model.builder;

import com.example.casadecambio.bitcoin.model.Compra;

import java.math.BigDecimal;

public class CompraBuilder {

    private BigDecimal quantidadeDeBitcoins;
    private BigDecimal valorDaCompra;
    private BigDecimal valorUnitarioBitcoin;
    private String cpf;

    public CompraBuilder setQuantidade(BigDecimal quantidade) {
        this.quantidadeDeBitcoins = quantidade;
        return this;
    }

    public CompraBuilder setValorDaCompra(BigDecimal valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
        return this;
    }

    public CompraBuilder setValorUnitarioBitcoin(BigDecimal valorUnitarioBitcoin) {
        this.valorUnitarioBitcoin = valorUnitarioBitcoin;
        return this;
    }

    public CompraBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Compra createCompra() {
        return new Compra(quantidadeDeBitcoins, valorDaCompra, valorUnitarioBitcoin, cpf);
    }
}