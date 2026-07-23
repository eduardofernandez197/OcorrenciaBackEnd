package com.coruja.ocorrencias.exception;
//classe de erro de somente de recursos não encontrados.
//Ex: não encontrado no banco 

// Exception usada quando algum recurso solicitado nao existe no banco.
public class NotFoundException extends RuntimeException{

    public NotFoundException (String message){
            super(message);
    }
    
}
