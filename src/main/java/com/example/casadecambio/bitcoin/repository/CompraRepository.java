package com.example.casadecambio.bitcoin.repository;

import com.example.casadecambio.bitcoin.model.Compra;

public interface CompraRepository {

    Compra save(Compra compra);

    Compra findByCpf(String cpf);
}
