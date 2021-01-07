package com.example.casadecambio.service;

import com.example.casadecambio.model.dto.BitcoinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BitcoinService {

    private final String LOCALHOST = "http://localhost:";
    private final String PORT_8082 = "8082";
    private final String BITCOIN = "/bitcoin/";
    private final String BITCOIN_URL = LOCALHOST + PORT_8082 + BITCOIN;
    private WebClient webClient;

    @Autowired
    public BitcoinService() {
        this.webClient = WebClient.create(LOCALHOST + PORT_8082);
    }

    public Mono<BitcoinDTO> getBitcoinPrice() {
        return  webClient
                .get()
                .uri(BITCOIN_URL)
                .retrieve()
                .bodyToMono(BitcoinDTO.class);
    }
}
