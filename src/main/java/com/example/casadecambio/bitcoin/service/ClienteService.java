package com.example.casadecambio.bitcoin.service;

import com.example.casadecambio.bitcoin.model.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ClienteService {

    private final String LOCALHOST = "http://localhost:";
    private final String PORT_8080 = "8080";
    private final String PORT_8081 = "8081";
    private final String CLIENTE = "/cliente/";
    private final String SALDO = "/saldo/";

    private WebClient webClient;

    @Autowired
    public ClienteService() {
        this.webClient = WebClient.create(LOCALHOST + PORT_8080);
        this.webClient = WebClient.create(LOCALHOST + PORT_8081);
    }

    public Flux<ClienteDTO> getClientInformations(String cpf) {
        return webClient
                .get()
                .uri(CLIENTE + cpf)
                .retrieve()
                .bodyToFlux(ClienteDTO.class);
    }
}
