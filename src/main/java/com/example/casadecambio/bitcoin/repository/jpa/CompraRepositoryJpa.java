package com.example.casadecambio.bitcoin.repository.jpa;

import com.example.casadecambio.bitcoin.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepositoryJpa extends JpaRepository<Compra, Long> {

    Compra findByCpf(String cpf);

}
