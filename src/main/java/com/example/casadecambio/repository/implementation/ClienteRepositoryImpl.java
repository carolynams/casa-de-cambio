package com.example.casadecambio.repository.implementation;

import com.example.casadecambio.model.Cliente;
import com.example.casadecambio.repository.ClienteRepository;
import com.example.casadecambio.repository.jpa.ClienteRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Cliente> findByCpf(Long cpf) {
        return repositoryJpa.findByCpfOrderByNomeAsc(cpf);
    }
}
