package com.example.casadecambio.model.dto;

import com.example.casadecambio.model.Conta;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private Long cpf;
    private Date dataDeNascimento;
    private Conta conta;
}
