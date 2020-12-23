package com.example.casadecambio.domain.model.repository;

import com.example.casadecambio.domain.model.Cliente;
import java.util.List;


public interface ClienteRepository {

    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    List<Cliente> findByCpf(String cpf);
}
