package com.example.casadecambio.bitcoin.repository.jpa;

import com.example.casadecambio.bitcoin.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepositoryJpa extends JpaRepository<Investimento, Long> {
}
