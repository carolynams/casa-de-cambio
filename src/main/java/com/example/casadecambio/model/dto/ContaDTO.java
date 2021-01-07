package com.example.casadecambio.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContaDTO {

    private Long id;
    private Long agencia;
    private Long conta;
    private String senha;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataDeCriacao;

    private BigDecimal saldo;

    @JsonIgnore
    private List<ClienteDTO> clientes;

    public ContaDTO() {
        this.clientes = new ArrayList();
        this.dataDeCriacao = now();
    }
}
