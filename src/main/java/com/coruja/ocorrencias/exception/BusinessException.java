package com.coruja.ocorrencias.exception;
//classe de erro de somente validações

    // Exception usada para regras de negocio invalidas, como arquivo em formato errado.
    public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}

