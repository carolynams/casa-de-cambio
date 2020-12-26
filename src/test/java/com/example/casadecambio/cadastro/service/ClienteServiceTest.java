package com.example.casadecambio.cadastro.service;

import com.example.casadecambio.cadastro.builder.ClienteBuilder;
import com.example.casadecambio.cadastro.builder.ContaBuilder;
import com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.Conta;
import com.example.casadecambio.cadastro.model.dto.ClienteDTO;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import com.example.casadecambio.cadastro.repository.ContaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException.CPF_JA_CADASTRADO;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ContaRepository contaRepository;

    @Before
    public void executeThis() {
        openMocks(this);
    }

    @Test
    public void shouldSaveACliente() {
        Cliente cliente = createCliente();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteDTO clienteDTO = new ClienteDTO().toDTO(cliente);
        Cliente saveCLient = clienteService.save(clienteDTO);
        assertEquals(cliente.getCpf(), saveCLient.getCpf());
        assertEquals(cliente.getNome(), saveCLient.getNome());
        assertEquals(cliente.getDataDeNascimento(), saveCLient.getDataDeNascimento());
        assertEquals(cliente.getConta(), saveCLient.getConta());
    }

    @Test
    public void shouldNotSaveClientWithTheSameCPf() {
        Cliente cliente = createCliente();

        when(clienteRepository.findByCpf(anyString())).thenReturn(List.of(cliente));

        ClienteDTO clienteDTO = new ClienteDTO().toDTO(cliente);
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class,
                () -> clienteService.save(clienteDTO));
        assertEquals(exception.getMessage(), CPF_JA_CADASTRADO);
    }

    private Cliente createCliente() {
        Conta conta = new ContaBuilder()
                .setConta(56478L)
                .setSaldo(valueOf(25600.56))
                .setSenha("senha1234")
                .createConta();

        return new ClienteBuilder()
                .setNome("Carolyna Mantovani de Souza")
                .setCpf("102.663.619-19")
                .setDataDeNascimento(of(1995, 11, 29))
                .setConta(conta)
                .createCliente();
    }
}
