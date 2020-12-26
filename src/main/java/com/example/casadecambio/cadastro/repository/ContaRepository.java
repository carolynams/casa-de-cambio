package com.example.casadecambio.cadastro.repository;

import com.example.casadecambio.cadastro.model.Conta;

import java.util.List;
import java.util.Set;

public interface ContaRepository {

    Conta findById(Long id);

    List<Conta> findAll();

    Set<Conta> findByContaOrderByClientesNomeAsc(Long conta);

}
