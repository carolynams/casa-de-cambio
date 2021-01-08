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
public class ClienteController {

    private WebClient webClient;

    private ExchangeFunction exchangeFunction;

    @Before
    public void executeThis() {
        openMocks(this);
        this.exchangeFunction = mock(ExchangeFunction.class);
        this.webClient = WebClient.create(LOCALHOST + PORT_8080);
    }

    @Test
    public void shoudlReturnClientByCPf() {
        webClient.get()
                .uri(CLIENTE + "/" + "102.663.619-19")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    @Test
    public void shoudlSave() {
        webClient.post()
                .uri(SAVE_CLIENT)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    @Test
    public void shouldUpdate() {
        webClient.put()
                .uri(UPDATE_CLIENT + "/" + "1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }
}
