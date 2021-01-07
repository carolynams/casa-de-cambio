package com.example.casadecambio.service;

import com.example.casadecambio.model.dto.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.casadecambio.utils.UrlHelper.*;

@Service
public class CompraService {

    private WebClient webClient;

    @Autowired
    private SaldoService saldoService;

    @Autowired
    public CompraService() {
        this.webClient = WebClient.create(LOCALHOST + PORT_8082);
    }

    public Mono<CompraDTO> buyBitcoin(CompraDTO compraDTO) {
        return webClient
                .post()
                .uri(SAVE_COMPRA)
                .body(Mono.just(compraDTO), CompraDTO.class)
                .retrieve()
                .bodyToMono(CompraDTO.class);
    }

    public Mono<CompraDTO> getAndBuyBitcoinPurchaseValue(CompraDTO compraDTO) {
        return webClient
                .post()
                .uri(COMPRA)
                .body(Mono.just(compraDTO), CompraDTO.class)
                .retrieve()
                .bodyToMono(CompraDTO.class);
    }

    public Flux<CompraDTO> getCompraDetails(String cpf) {
        return webClient
                .get()
                .uri(COMPRA + "/" + cpf)
                .retrieve()
                .bodyToFlux(CompraDTO.class);
    }
}
