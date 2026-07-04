package com.coruja.ocorrencias.validation;

import org.springframework.stereotype.Component;

import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;
import com.coruja.ocorrencias.exception.BusinessException;
@Component
public class ValidaTitulo implements OcorrenciaValidator {

    public OcorrenciaRequestDTO validar (OcorrenciaRequestDTO dto){
        if (dto.getTitulo() == null || dto.getTitulo().isBlank()) {
        throw new BusinessException("Titulo nao pode ser vazio, ou nullo");      
        }
        return dto;
    }
    
}
