package com.coruja.ocorrencias.validation;

import org.springframework.stereotype.Component;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
@Component
public class ValidaTitulo implements ValidaOcorrenciaInterface {

    public OcorrenciaDTO validar (OcorrenciaDTO dto){
        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
        throw new RuntimeException("Titulo nao pode ser vazio, ou nullo");      
        }
        return dto;
    }
    
}
