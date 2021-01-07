package com.example.casadecambio.service;

import com.example.casadecambio.model.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    private final String LOCALHOST = "http://localhost";
    private final String PORT_8080 = ":8080";
    private final String CLIENTE = "/cliente";
    private final String SAVE = "/save";
    private final String UPDATE = "/update";
    private final String SAVE_CLIENT = LOCALHOST + PORT_8080 + CLIENTE + SAVE;
    private final String UPDATE_CLIENT = LOCALHOST + PORT_8080 + CLIENTE + UPDATE;

    private WebClient webClient;

    @Autowired
    public ClienteService() {
        this.webClient = WebClient.create(LOCALHOST + PORT_8080);
    }

    public Mono<ClienteDTO> getClientInformations(String cpf) {
        return webClient
                .get()
                .uri(CLIENTE + "/" + cpf)
                .retrieve()
                .bodyToMono(ClienteDTO.class);
    }

    public Mono<ClienteDTO> save(ClienteDTO clienteDTO) {
        return webClient
                .post()
                .uri(SAVE_CLIENT)
                .body(Mono.just(clienteDTO), ClienteDTO.class)
                .retrieve()
                .bodyToMono(ClienteDTO.class);
    }

    public Mono<ClienteDTO> update(ClienteDTO clienteDTO, Long id) {
        return webClient
                .put()
                .uri(UPDATE_CLIENT + "/" + id)
                .body(Mono.just(clienteDTO), ClienteDTO.class)
                .retrieve()
                .bodyToMono(ClienteDTO.class);
    }
}
