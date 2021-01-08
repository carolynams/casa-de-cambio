package com.example.casadecambio.service;

import com.example.casadecambio.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.model.dto.BitcoinDTO;
import com.example.casadecambio.model.dto.CompraDTO;
import com.example.casadecambio.model.dto.SaldoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.casadecambio.utils.UrlHelper.*;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

@Service
public class SaldoService {

    private WebClient webClient;

    @Autowired
    private BitcoinService bitcoinService;

    @Autowired
    private CompraService compraService;

    @Autowired
    public SaldoService() {
        this.webClient = WebClient.create(LOCALHOST + PORT_8081);
    }

    public Mono<SaldoDTO> transferencia(String cpfOrigem, String cpfDestino, BigDecimal valor) {
        return webClient
                .post()
                .uri(TRANSFERE + "/" + cpfOrigem + "/" + cpfDestino + "/" + valor)
                .retrieve()
                .bodyToMono(SaldoDTO.class);
    }

    public Mono<SaldoDTO> atualizarSaldo(String cpfOrigem, BigDecimal valor) {
        return webClient
                .post()
                .uri(UPDATE_TRANSFERENCIA + "/" + cpfOrigem + "/" + valor)
                .retrieve()
                .bodyToMono(SaldoDTO.class);
    }

    public Mono<SaldoDTO> create(String cpf) {
        return webClient
                .post()
                .uri(SAVE_TRANSFERENCIA + "/" + cpf)
                .retrieve()
                .bodyToMono(SaldoDTO.class);
    }

    public Mono<SaldoDTO> getSaldo(String cpf) {
        return webClient
                .get()
                .uri(GET_SALDO + "/" + cpf)
                .retrieve()
                .bodyToMono(SaldoDTO.class);
    }
}
