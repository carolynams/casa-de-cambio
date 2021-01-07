package com.example.casadecambio.service;

import com.example.casadecambio.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.model.dto.BitcoinDTO;
import com.example.casadecambio.model.dto.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
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
    private ClienteService clienteService;

    @Autowired
    private BitcoinService bitcoinService;

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

    public Mono<CompraDTO> tryBuyBitcoin(CompraDTO compraDTO) {
        BitcoinDTO bitcoin = bitcoinService.getBitcoinPrice().block();

        this.clienteService.getClientInformations(compraDTO.getCpf())
                .map(clienteDTO -> {
                    BigDecimal getSaldoDoCliente = clienteDTO.getConta().getSaldo();
                    if (bitcoin.getData().getAmount().floatValue() >= getSaldoDoCliente.floatValue()) {
                        throw new DataIntegrityViolationException(DataIntegrityViolationException.SALDO_INSUFICIENTE);
                    }

                    double valorAtualDoBitcoinFormatado = (bitcoin.getData().getAmount().doubleValue() * compraDTO.getQuantidadeDeBitcoins().doubleValue());

                    BigDecimal novoSaldo = getSaldoDoCliente
                            .setScale(3, HALF_UP)
                            .add(valueOf(valorAtualDoBitcoinFormatado).setScale(3, HALF_UP).negate());

                    clienteDTO.getConta().setSaldo(novoSaldo);

                    clienteService.update(clienteDTO, clienteDTO.getId());
                    return clienteDTO;
                });
        return buyBitcoin(compraDTO);
    }

    public Mono<CompraDTO> getCompraDetails(String cpf) {
        return webClient
                .get()
                .uri(COMPRA + "/" + cpf)
                .retrieve()
                .bodyToMono(CompraDTO.class);
    }
}
