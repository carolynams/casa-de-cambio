package com.example.casadecambio.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ZERO;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SaldoDTO {
    private Long id;

    private BigDecimal valor;

    private String cpf;

    public SaldoDTO(String cpf) {
        this.cpf = cpf;
        this.valor = ZERO.setScale(3, RoundingMode.HALF_UP);
    }

    public SaldoDTO() {
    }

    public SaldoDTO update(SaldoDTO saldoDTO) {
        BeanUtils.copyProperties(saldoDTO, this, "id");
        return this;
    }
}
