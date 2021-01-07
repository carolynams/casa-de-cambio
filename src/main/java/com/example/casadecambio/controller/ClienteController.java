package com.example.casadecambio.controller;


import com.example.casadecambio.model.dto.ClienteDTO;
import com.example.casadecambio.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{cpf}")
    @ApiOperation("Obtem informações do cliente de acordo com o CPF informado")
    public Mono<ClienteDTO> getClientInformations(@PathVariable String cpf) {
        return service.getClientInformations(cpf);
    }

    @PostMapping("/save")
    @ApiOperation("Cria um novo cliente com informações da conta")
    public Mono<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) {
        return service.save(clienteDTO);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza os dados do cliente e conta")
    public Mono<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO, @PathVariable("id") Long id) {
        return service.update(clienteDTO, id);
    }
}
