package com.coruja.ocorrencias.mapper;

import com.coruja.ocorrencias.model.OcorrenciaEntity;

public class OcorrenciaDTO {

    public OcorrenciaEntity toEnity(OcorrenciaDTO dto){
        OcorrenciaEntity ocorrencia = new OcorrenciaEntity();
        ocorrencia.setTitulo(null);

    }
    
}
