package com.example.casadecambio.bitcoin.service;

import com.example.casadecambio.bitcoin.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.bitcoin.model.Bitcoin;
import com.example.casadecambio.bitcoin.model.Compra;
import com.example.casadecambio.bitcoin.model.Investimento;
import com.example.casadecambio.bitcoin.model.builder.CompraBuilder;
import com.example.casadecambio.bitcoin.model.builder.InvestimentoBuilder;
import com.example.casadecambio.bitcoin.repository.CompraRepository;
import com.example.casadecambio.bitcoin.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static com.example.casadecambio.bitcoin.exceptions.DataIntegrityViolationException.SALDO_INSUFICIENTE;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_EVEN;
import static java.time.LocalDateTime.now;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private BitcoinService bitcoinService;

    public Compra buyBitcoin(String cpf, BigDecimal quantidade, BigDecimal saldo) {
        Compra compra = getBitcoinPurchaseValue(quantidade, cpf)
                .block();

        BigDecimal valorTotalDoBitcoin = compra.getValorDaCompra();

        if (saldo.floatValue() >= valorTotalDoBitcoin.floatValue()) {
            valorTotalDoBitcoin.add(saldo.negate());

            Investimento investimento = setInvestimento(valorTotalDoBitcoin, quantidade, cpf)
                    .block();

            investimentoRepository.save(investimento);
        } else {
            throw new DataIntegrityViolationException(SALDO_INSUFICIENTE);
        }
        return repository.save(compra);
    }

    private Mono<Compra> getBitcoinPurchaseValue(BigDecimal quantidade, String cpf) {
        Mono<Bitcoin> bitcoinPrice = getBitcoinPrice();

        return bitcoinPrice
                .map(Bitcoin::getData)
                .map(bitcoin -> new CompraBuilder()
                        .setCpf(cpf)
                        .setQuantidade(quantidade)
                        .setValorDaCompra(bitcoin.getAmount().multiply(quantidade).setScale(2, HALF_EVEN))
                        .setValorUnitarioBitcoin(bitcoin.getAmount().setScale(2, HALF_EVEN))
                        .createCompra());
    }

    public Mono<Bitcoin> getBitcoinPrice() {
        return bitcoinService.getBitcoinPrice();
    }

    private Mono<Investimento> setInvestimento(BigDecimal valorTotalDoBitcoin, BigDecimal quantidade, String cpf) {
        Mono<Bitcoin> bitcoinPrice = getBitcoinPrice();

        return bitcoinPrice
                .map(Bitcoin::getData)
                .map(bitcoin -> new InvestimentoBuilder()
                        .setCpf(cpf)
                        .setTipo(bitcoin.getBase())
                        .setValorInvestido(valorTotalDoBitcoin.setScale(2, HALF_EVEN))
                        .setQuantidadeInvestida(quantidade)
                        .setLucro(ZERO)
                        .setDataDoInvestimento(now())
                        .setCotacaoAtualBitcoin(bitcoin.getAmount())
                        .createInvestimento());
    }
}
