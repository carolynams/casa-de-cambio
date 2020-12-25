package com.example.casadecambio.service;

import br.com.caelum.stella.validation.CPFValidator;
import com.example.casadecambio.exceptions.DataIntegritViolationException;
import com.example.casadecambio.model.Cliente;
import com.example.casadecambio.model.dto.ClienteDTO;
import com.example.casadecambio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.example.casadecambio.exceptions.DataIntegritViolationException.CPF_INVALIDO;
import static com.example.casadecambio.exceptions.DataIntegritViolationException.CPF_JA_CADASTRADO;


@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente().fromDTO(clienteDTO);
        String cpf = cliente.getCpf();

        validateCpf(cpf);
        checkIfAlreadyExists(cpf);
        return clienteRepository.save(cliente);
    }

    private void checkIfAlreadyExists(String cpf) {
        List<Cliente> cpfFound = clienteRepository.findByCpf(cpf);
        if (cpfFound.size() >= 1) {
            throw new DataIntegritViolationException(CPF_JA_CADASTRADO);
        }
    }

    private void validateCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            throw new DataIntegritViolationException(CPF_INVALIDO);
        }
    }
}
