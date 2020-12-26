package com.example.casadecambio.cadastro.repository;

import com.example.casadecambio.cadastro.model.Cliente;

import java.util.List;


public interface ClienteRepository {

    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    List<Cliente> findAll();

    List<Cliente> findByCpf(String cpf);
}
