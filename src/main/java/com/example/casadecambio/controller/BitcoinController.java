package com.example.casadecambio.controller;

import com.example.casadecambio.model.dto.BitcoinDTO;
import com.example.casadecambio.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinController {

    @Autowired
    private BitcoinService service;

    @GetMapping("/")
    public Mono<BitcoinDTO> getBitcoinPrice() {
        return service.getBitcoinPrice();
    }
}
