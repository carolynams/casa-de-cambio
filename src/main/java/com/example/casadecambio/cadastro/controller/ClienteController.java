package com.example.casadecambio.cadastro.controller;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.dto.ClienteDTO;
import com.example.casadecambio.cadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/save")
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok().body(service.save(clienteDTO));
    }
}
