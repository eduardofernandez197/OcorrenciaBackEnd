package com.coruja.ocorrencias.exception;
//classe de erro de somente validações

    public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}

