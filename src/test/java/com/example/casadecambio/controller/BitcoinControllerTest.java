package com.example.casadecambio.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;

import static com.example.casadecambio.utils.UrlHelper.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.openMocks;

@WebFluxTest
public class BitcoinControllerTest {

    private WebClient webClient;

    private ExchangeFunction exchangeFunction;

    @Before
    public void executeThis() {
        openMocks(this);
        this.exchangeFunction = mock(ExchangeFunction.class);
        this.webClient = WebClient.create(LOCALHOST + PORT_8082);
    }

    @Test
    public void shouldGetBitcoinPrice() {
        webClient.get()
                .uri(BITCOIN)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }
}
