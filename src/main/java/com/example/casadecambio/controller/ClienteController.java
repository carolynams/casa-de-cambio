package com.example.casadecambio.controller;


import com.example.casadecambio.model.dto.ClienteDTO;
import com.example.casadecambio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{cpf}")
    public Mono<ClienteDTO> getClientInformations(@PathVariable String cpf) {
        return service.getClientInformations(cpf);
    }

    @PostMapping("/save")
    public Mono<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) {
        return service.save(clienteDTO);
    }

    @PutMapping("/update/{id}")
    public Mono<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO, @PathVariable("id") Long id) {
        return service.update(clienteDTO, id);
    }
}
