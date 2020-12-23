package com.example.casadecambio.service.controller;

import com.example.casadecambio.application.ClienteService;
import com.example.casadecambio.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping("/save")
    public Cliente save(Cliente cliente) {
        return service.save(cliente);
    }
}
