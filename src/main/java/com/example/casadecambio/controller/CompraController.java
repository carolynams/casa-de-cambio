package com.example.casadecambio.controller;


import com.example.casadecambio.model.dto.CompraDTO;
import com.example.casadecambio.service.CompraService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService service;

    @PostMapping("/")
    @ApiOperation("Compra o Bitcoin")
    public Mono<CompraDTO> buyBitcoin(@RequestBody CompraDTO compraDTO) {
        return service.getAndBuyBitcoinPurchaseValue(compraDTO);
    }

    @GetMapping("/{cpf}")
    @ApiOperation("Obtem os detalhes da compra por CPF")
    public Flux<CompraDTO> getCompraDetails(@PathVariable String cpf) {
        return service.getCompraDetails(cpf);
    }
}
