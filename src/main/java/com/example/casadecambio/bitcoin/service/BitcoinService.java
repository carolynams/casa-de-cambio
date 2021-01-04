package com.example.casadecambio.bitcoin.service;

import com.example.casadecambio.bitcoin.model.Bitcoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BitcoinService {

    private final String URL = "https://api.coinbase.com/v2/";
    private final String BRL_PRICE = "prices/spot?currency=BRL";
    private WebClient webClient;

    @Autowired
    public BitcoinService() {
        this.webClient = WebClient.create(URL);
    }

    public Mono<Bitcoin> getBitcoinPrice() {
        return webClient
                .get()
                .uri(BRL_PRICE)
                .retrieve()
                .bodyToMono(Bitcoin.class);
    }
}
