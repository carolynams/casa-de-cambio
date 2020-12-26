package com.example.casadecambio.cadastro.builder;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.Conta;

import java.time.LocalDate;

public class ClienteBuilder {

    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private Conta conta;

    public ClienteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public ClienteBuilder setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Cliente createCliente() {
        return new Cliente(nome, cpf, dataDeNascimento, conta);
    }
}