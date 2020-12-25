package com.example.casadecambio.repository.jpa;

import com.example.casadecambio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpfOrderByNomeAsc(String cpf);
}
