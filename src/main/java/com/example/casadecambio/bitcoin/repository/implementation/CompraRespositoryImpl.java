package com.example.casadecambio.bitcoin.repository.implementation;

import com.example.casadecambio.bitcoin.model.Compra;
import com.example.casadecambio.bitcoin.repository.CompraRepository;
import com.example.casadecambio.bitcoin.repository.jpa.CompraRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompraRespositoryImpl implements CompraRepository {

    @Autowired
    private CompraRepositoryJpa repositoryJpa;

    @Override
    public Compra save(Compra compra) {
        return repositoryJpa.save(compra);
    }

    @Override
    public Compra findByCpf(String cpf) {
        return repositoryJpa.findByCpf(cpf);
    }
}
