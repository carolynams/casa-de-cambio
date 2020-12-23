package com.example.casadecambio.port.adapter.persistence.repository;

import com.example.casadecambio.domain.model.Cliente;
import com.example.casadecambio.domain.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

//    @Autowired
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
    public List<Cliente> findByCpf(String cpf) {
        return repositoryJpa.findByCpf(cpf);
    }
}
