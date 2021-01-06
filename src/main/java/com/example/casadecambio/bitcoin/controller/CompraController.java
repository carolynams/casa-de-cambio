package com.example.casadecambio.bitcoin.controller;


import com.example.casadecambio.bitcoin.model.Compra;
import com.example.casadecambio.bitcoin.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService service;

    @GetMapping("/")
    public Compra getBitcoinPrice(@RequestParam String cpf, @RequestParam BigDecimal quantidade, @RequestParam BigDecimal saldo) {
        return service.buyBitcoin(cpf, quantidade, saldo);
    }
}
