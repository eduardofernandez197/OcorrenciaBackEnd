package com.coruja.ocorrencias.exception;

// Exception usada para erros de validacao especificos da aplicacao.
public class ValidationException extends RuntimeException {

    public ValidationException(String message){
        super(message);
    }
    
}
