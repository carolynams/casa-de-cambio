package com.example.casadecambio.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BitcoinDTO {

    private DataDTO data;

    public BitcoinDTO() {
    }

    public BitcoinDTO(DataDTO data) {
        this.data = data;
    }
}
