package com.example.casadecambio.service;

import com.example.casadecambio.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.model.dto.BitcoinDTO;
import com.example.casadecambio.model.dto.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

@Service
public class CompraService {

    private final String LOCALHOST = "http://localhost";
    private final String PORT_8082 = ":8082";
    private final String COMPRA = "/compra/";
    private final String SAVE_COMPRA = LOCALHOST + PORT_8082 + COMPRA;

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

//    public Mono<CompraDTO> tryBuyBitcoin(CompraDTO compraDTO) {
//        BitcoinDTO bitcoin = bitcoinService.getBitcoinPrice().block();
//
//        return this.saldoService.getSaldo(compraDTO.getCpf())
//                .flatMap(saldoDTO -> {
//                    BigDecimal getSaldoDoCliente = saldoDTO.getValor();
//                    double valorAtualDoBitcoinFormatado = (bitcoin.getData().getAmount().doubleValue() *
//                            compraDTO.getQuantidadeDeBitcoins().doubleValue());
//
//                    if (valorAtualDoBitcoinFormatado >= getSaldoDoCliente.floatValue()) {
//                        throw new DataIntegrityViolationException(DataIntegrityViolationException.SALDO_INSUFICIENTE);
//                    }
//
//                    BigDecimal novoSaldo = getSaldoDoCliente
//                            .setScale(3, HALF_UP)
//                            .add(valueOf(valorAtualDoBitcoinFormatado).setScale(3, HALF_UP).negate());
//
//                    saldoDTO.setValor(novoSaldo);
//                    compraDTO.setValorDaCompra(valueOf(valorAtualDoBitcoinFormatado));
//                    buyBitcoin(compraDTO);
//                    saldoService.atualizarSaldo(compraDTO.getCpf(), novoSaldo);
//                    return getAndBuyBitcoinPurchaseValue(compraDTO);
//                });
//    }

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
