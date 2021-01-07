package com.example.casadecambio.controller;

import com.example.casadecambio.model.dto.SaldoDTO;
import com.example.casadecambio.service.SaldoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/saldo")
public class SaldoController {

    @Autowired
    private SaldoService service;

    @PostMapping("/transferencia/{cpfOrigem}/{cpfDestino}/{valor}")
    @ApiOperation("Realiza a transferencia entre dois cpf e salva a operação")
    public Mono<SaldoDTO> transferencia(@PathVariable String cpfOrigem, @PathVariable String cpfDestino, @PathVariable BigDecimal valor) {
        return service.transferencia(cpfOrigem, cpfDestino, valor);
    }

    @PostMapping("/update/{cpfOrigem}/{valor}")
    @ApiOperation("Salva um saldo e realiza a transferencia para o mesmo cpf")
    public Mono<SaldoDTO> atualizarSaldo(@PathVariable String cpfOrigem, @PathVariable BigDecimal valor) {
        return service.atualizarSaldo(cpfOrigem, valor);
    }

    @PostMapping("/save/{cpf}")
    @ApiOperation("Cria uma conta de investimento com saldo 0")
    public Mono<SaldoDTO> create(@PathVariable String cpf) {
        return service.create(cpf);
    }

    @GetMapping("/{cpf}")
    @ApiOperation("Obtem saldo do cleinte")
    private Mono<SaldoDTO> getSaldo(@PathVariable String cpf) {
        return service.getSaldo(cpf);
    }

    @PostMapping("/update/saldo/{cpf}")
    @ApiOperation("Atualiza o saldo do cliente")
    public Mono<SaldoDTO> afterBuyBitcoinUpdateClientSaldo(@PathVariable String cpf) {
        return service.afterBuyBitcoinUpdateClientSaldo(cpf);
    }
}
