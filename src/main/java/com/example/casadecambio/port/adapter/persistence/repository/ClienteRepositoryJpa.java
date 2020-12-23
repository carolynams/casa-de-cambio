package com.example.casadecambio.port.adapter.persistence.repository;

import com.example.casadecambio.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpf(String cpf);
}
