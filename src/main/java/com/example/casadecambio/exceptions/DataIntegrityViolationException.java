package com.example.casadecambio.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

    public static final String SALDO_INSUFICIENTE = "Saldo do cliente insuficiente para realizar a compra de Bitcoins";

    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
