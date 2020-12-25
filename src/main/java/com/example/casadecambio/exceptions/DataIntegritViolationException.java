package com.example.casadecambio.exceptions;

public class DataIntegritViolationException extends RuntimeException{

    public static final String CPF_JA_CADASTRADO = "O CPF informado já está cadastrado no sistema";
    public static final String CPF_INVALIDO = "O CPF informado é inválido";
    public static final String CONTA_CADASTRADA = "A Conta informada já está cadastrada no sistema";

    public DataIntegritViolationException(String msg){
        super(msg);
    }
}
