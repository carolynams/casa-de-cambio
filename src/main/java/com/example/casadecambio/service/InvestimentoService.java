package com.example.casadecambio.service;

import com.example.casadecambio.model.dto.InvestimentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class InvestimentoService {

    private final String LOCALHOST = "http://localhost";
    private final String PORT_8082 = ":8082";
    private final String INVESTIMENTO = "/investimento/";
    private final String GET_INVESTIMENTO = LOCALHOST + PORT_8082 + INVESTIMENTO;

    private WebClient webClient;

    @Autowired
    public InvestimentoService() {
        this.webClient = WebClient.create(LOCALHOST + PORT_8082);
    }

    public Mono<InvestimentoDTO> getValorInvestido(String cpf) {
        return webClient
                .get()
                .uri(GET_INVESTIMENTO + cpf)
                .retrieve()
                .bodyToMono(InvestimentoDTO.class);
    }
}
