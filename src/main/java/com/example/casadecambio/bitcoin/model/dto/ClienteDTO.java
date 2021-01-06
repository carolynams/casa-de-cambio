package com.example.casadecambio.bitcoin.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;

    @ManyToOne(cascade = CascadeType.ALL, fetch = LAZY)
    private ContaDTO conta;

}
