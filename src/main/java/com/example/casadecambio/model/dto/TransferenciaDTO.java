package com.example.casadecambio.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransferenciaDTO {

    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataDaTransferencia;
    private String cpf;
    private BigDecimal valor;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(String cpf, BigDecimal valor) {
        this.cpf = cpf;
        this.valor = valor;
        this.dataDaTransferencia = LocalDateTime.now();
    }
}
