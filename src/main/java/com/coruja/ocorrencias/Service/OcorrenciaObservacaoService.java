package com.coruja.ocorrencias.service;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;
import com.coruja.ocorrencias.dto.response.ObservacoesResponseDTO;
import com.coruja.ocorrencias.entity.ObservacaoOcorrenciaEntity;
import com.coruja.ocorrencias.mapper.ObservacaoMapper;

public class OcorrenciaObservacaoService {

    private ObservacoesRequestDTO observacoes;
    private ObservacaoMapper observacoesMapper;
    private ObservacaoOcorrenciaEntity observacoesEntity;
    public OcorrenciaObservacaoService(ObservacoesRequestDTO observacoes, ObservacaoMapper observacoesMapper,
            ObservacaoOcorrenciaEntity observacaoEntity) {
        this.observacoes = observacoes;
        this.observacoesMapper = observacoesMapper;
        this.observacoesEntity = observacaoEntity;
    }
public ObservacoesResponseDTO salvar (ObservacoesRequestDTO dto){

    

return null;
}
    
    
}
