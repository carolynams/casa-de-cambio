package com.example.casadecambio.cadastro.builder;

import com.example.casadecambio.cadastro.model.Conta;

import java.math.BigDecimal;

public class ContaBuilder {
    private Long agencia;
    private Long conta;
    private String senha;
    private BigDecimal saldo;

    public ContaBuilder setAgencia(Long agencia) {
        this.agencia = agencia;
        return this;
    }

    public ContaBuilder setConta(Long conta) {
        this.conta = conta;
        return this;
    }

    public ContaBuilder setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public ContaBuilder setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
        return this;
    }

    public Conta createConta() {
        return new Conta(agencia, conta, senha, saldo);
    }
}