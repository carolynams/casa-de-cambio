package com.example.casadecambio.bitcoin.controller;

import com.example.casadecambio.bitcoin.model.Investimento;
import com.example.casadecambio.bitcoin.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

    @Autowired
    private InvestimentoService service;

    @GetMapping("/")
    public Investimento getLucro(@RequestParam String cpf) {
        return service.getValorInvestido(cpf);
    }
}
