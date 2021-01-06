package com.example.casadecambio.bitcoin.repository.implementation;

import com.example.casadecambio.bitcoin.model.Investimento;
import com.example.casadecambio.bitcoin.repository.InvestimentoRepository;
import com.example.casadecambio.bitcoin.repository.jpa.InvestimentoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvestimentoRespositoryImpl implements InvestimentoRepository {

    @Autowired
    private InvestimentoRepositoryJpa repositoryJpa;

    @Override
    public Investimento save(Investimento investimento) {
        return repositoryJpa.save(investimento);
    }

}
