package com.example.casadecambio.controller;


import com.example.casadecambio.model.dto.InvestimentoDTO;
import com.example.casadecambio.service.InvestimentoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

    @Autowired
    private InvestimentoService service;

    @GetMapping("/{cpf}")
    @ApiOperation("Recebe informações de lucro don cliente")
    public Mono<InvestimentoDTO> getValorInvestido(@PathVariable String cpf) {
        return service.getValorInvestido(cpf);
    }
}
