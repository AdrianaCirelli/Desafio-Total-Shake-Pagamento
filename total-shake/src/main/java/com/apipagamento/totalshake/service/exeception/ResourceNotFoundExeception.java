package com.apipagamento.totalshake.service.exeception;

public class ResourceNotFoundExeception extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundExeception(String msg){
        super(msg);
    }
}
