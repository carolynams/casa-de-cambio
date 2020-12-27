package com.example.casadecambio.cadastro.repository.implementation;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import com.example.casadecambio.cadastro.repository.jpa.ClienteRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private ClienteRepositoryJpa repositoryJpa;

    @Override
    public Cliente save(Cliente cliente) {
        return repositoryJpa.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> foundClient = repositoryJpa.findById(id);
        return foundClient.orElseThrow();
    }

    @Override
    public List<Cliente> findAll() {
        return repositoryJpa.findAll();
    }

    @Override
    public List<Cliente> findByCpf(String cpf) {
        List<Cliente> foundCpf = repositoryJpa.findByCpf(cpf).orElse(new ArrayList<>());
        return foundCpf;
    }
}
