package com.example.casadecambio.repository;

import com.example.casadecambio.model.Conta;

import java.util.List;
import java.util.Set;

public interface ContaRepository {

    Conta findById(Long id);

    List<Conta> findAll();

    Set<Conta> findByContaOrderByClientesNomeAsc(Long conta);

}
