package com.example.casadecambio.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;

    public ClienteDTO() {
    }
}
