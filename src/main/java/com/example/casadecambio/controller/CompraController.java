package com.example.casadecambio.controller;


import com.example.casadecambio.model.dto.CompraDTO;
import com.example.casadecambio.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService service;

    @PostMapping("/")
    public Mono<CompraDTO> buyBitcoin(@RequestBody CompraDTO compraDTO) {
        return service.tryBuyBitcoin(compraDTO);
    }

    @GetMapping("/{cpf}")
    public Mono<CompraDTO> getCompraDetails(@PathVariable String cpf) {
        return service.getCompraDetails(cpf);
    }
}
