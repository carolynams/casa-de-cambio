package com.example.casadecambio.model;

import com.example.casadecambio.model.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataDeNascimento;

    @ManyToOne(cascade = CascadeType.ALL, fetch = LAZY)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Cliente() {
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        copyProperties(clienteDTO, this);
        return this;
    }
}
