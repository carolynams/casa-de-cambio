package com.example.casadecambio.cadastro.repository.jpa;

import com.example.casadecambio.cadastro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long> {

    Optional<List<Cliente>> findByCpf(String cpf);
}
