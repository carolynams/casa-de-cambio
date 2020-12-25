package com.example.casadecambio.repository.implementation;

import com.example.casadecambio.model.Conta;
import com.example.casadecambio.repository.ContaRepository;
import com.example.casadecambio.repository.jpa.ContaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ContaRepositoryImpl implements ContaRepository {

    @Autowired
    private ContaRepositoryJpa repositoryJpa;

    @Override
    public Conta findById(Long id) {
        Optional<Conta> foundConta = repositoryJpa.findById(id);
        return foundConta.orElseThrow();
    }

    @Override
    public List<Conta> findAll() {
        return repositoryJpa.findAll();
    }

    @Override
    public Set<Conta> findByContaOrderByClientesNomeAsc(Long conta) {
        return repositoryJpa.findByContaOrderByClientesNomeAsc(conta);
    }
}
