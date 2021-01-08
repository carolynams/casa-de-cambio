package com.example.casadecambio.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

import static com.example.casadecambio.utils.UrlHelper.*;
import static java.math.BigDecimal.valueOf;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.openMocks;

@WebFluxTest
public class SaldoControllerTest {

    private WebClient webClient;
    private ExchangeFunction exchangeFunction;

    private static final String CPF_ORIGEM = "102.663.619-19";
    private static final String CPF_DESTINO = "617.287.489-68";
    private static final BigDecimal VALOR = valueOf(250);

    @Before
    public void executeThis() {
        openMocks(this);
        this.exchangeFunction = mock(ExchangeFunction.class);
        this.webClient = WebClient.create(LOCALHOST + PORT_8082);
    }

    @Test
    public void transferencia() {
         webClient
                .post()
                .uri(TRANSFERE + "/" + CPF_ORIGEM + "/" + CPF_DESTINO + "/" + VALOR)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    @Test
    public void atualizarSaldo() {
         webClient
                .post()
                .uri(UPDATE_TRANSFERENCIA + "/" + CPF_ORIGEM + "/" + VALOR)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    @Test
    public void create() {
         webClient
                .post()
                .uri(SAVE_TRANSFERENCIA + "/" + CPF_DESTINO)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }
}