package com.example.casadecambio.repository.jpa;

import com.example.casadecambio.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface ContaRepositoryJpa extends JpaRepository<Conta, Long> {

    Set<Conta> findByContaOrderByClientesNomeAsc(Long Conta);
}
