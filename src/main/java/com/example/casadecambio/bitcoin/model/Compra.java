package com.example.casadecambio.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "COMPRA")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal quantidadeDeBitcoins;

    private BigDecimal valorDaCompra;

    private BigDecimal valorUnitarioBitcoin;

    @NotNull
    private String cpf;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime horarioDaTransacao;

    public Compra() {
        this.horarioDaTransacao = LocalDateTime.now();
    }

    public Compra(BigDecimal quantidadeDeBitcoins, BigDecimal valorDaCompra, BigDecimal valorUnitarioBitcoin, String cpf) {
        this.quantidadeDeBitcoins = quantidadeDeBitcoins;
        this.valorDaCompra = valorDaCompra;
        this.valorUnitarioBitcoin = valorUnitarioBitcoin;
        this.horarioDaTransacao = LocalDateTime.now();
        this.cpf = cpf;
    }
}
