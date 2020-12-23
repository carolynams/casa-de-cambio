package com.example.casadecambio.application;

import com.example.casadecambio.domain.model.Cliente;
import com.example.casadecambio.domain.model.repository.ClienteRepository;
import com.example.casadecambio.exceptions.DataIntegritViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.casadecambio.exceptions.DataIntegritViolationException.CPF_JA_CADASTRADO;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
//        List<Cliente> cpfFound = clienteRepository.findByCpf(cliente.getCpf());
//        checkIfAlreadyExists(cpfFound);
        return clienteRepository.save(cliente);
    }

    private void checkIfAlreadyExists(List<Cliente> cpfFounded) {
        if(cpfFounded.size() >= 1){
            throw new DataIntegritViolationException(CPF_JA_CADASTRADO);
        }
    }
}
