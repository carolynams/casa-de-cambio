package com.example.casadecambio.controller;

import com.example.casadecambio.model.dto.ClienteDTO;
import com.example.casadecambio.service.ClienteService;
import com.example.casadecambio.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/save")
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok().body(service.save(clienteDTO));
    }
}
