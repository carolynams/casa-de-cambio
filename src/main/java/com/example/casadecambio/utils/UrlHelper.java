package com.example.casadecambio.utils;

public class UrlHelper {

    public static final String LOCALHOST = "http://localhost";
    public static final String PORT_8080 = ":8080";
    public static final String PORT_8081 = ":8081";
    public static final String PORT_8082 = ":8082";


    public static final String CLIENTE = "/cliente";
    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String COMPRA = "/compra/";
    public static final String INVESTIMENTO = "/investimento/";
    public static final String BITCOIN = "/bitcoin/";
    public static final String SALDO = "/saldo";

    public static final String TRANSFERENCIA = "/transferencia";
    public static final String SAVE_TRANSFERENCIA = LOCALHOST + PORT_8081 + SALDO + SAVE;
    public static final String UPDATE_TRANSFERENCIA = LOCALHOST + PORT_8081 + SALDO + UPDATE;
    public static final String TRANSFERE = LOCALHOST + PORT_8081 + SALDO + TRANSFERENCIA;
    public static final String GET_SALDO = LOCALHOST + PORT_8081 + SALDO;

    public static final String BITCOIN_URL = LOCALHOST + PORT_8082 + BITCOIN;
    public static final String SAVE_COMPRA = LOCALHOST + PORT_8082 + COMPRA;
    public static final String GET_INVESTIMENTO = LOCALHOST + PORT_8082 + INVESTIMENTO;
    public static final String SAVE_CLIENT = LOCALHOST + PORT_8080 + CLIENTE + SAVE;
    public static final String UPDATE_CLIENT = LOCALHOST + PORT_8080 + CLIENTE + UPDATE;

    public UrlHelper() {
    }
}
