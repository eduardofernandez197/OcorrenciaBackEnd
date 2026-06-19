package com.coruja.ocorrencias.exception;
//classe de erro de somente de recursos não encontrados.
//Ex: não encontrado no banco 

public class NotFoundException extends RuntimeException{

    public NotFoundException (String message){
            super(message);
    }
    
}
