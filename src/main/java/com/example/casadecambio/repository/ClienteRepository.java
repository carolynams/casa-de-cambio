package com.example.casadecambio.repository;

import com.example.casadecambio.model.Cliente;
import java.util.List;


public interface ClienteRepository {

    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    List<Cliente> findAll();

    List<Cliente> findByCpf(Long cpf);
}
