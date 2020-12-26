package com.example.casadecambio.cadastro.model;

import com.example.casadecambio.cadastro.model.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;

    @ManyToOne(cascade = CascadeType.ALL, fetch = LAZY)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Cliente(String nome, String cpf, LocalDate dataDeNascimento, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.conta = conta;
    }

    public Cliente() {
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        copyProperties(clienteDTO, this);
        return this;
    }
}
