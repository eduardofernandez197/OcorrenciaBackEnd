package com.coruja.ocorrencias.mapper;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;
import com.coruja.ocorrencias.dto.response.ObservacoesResponseDTO;
import com.coruja.ocorrencias.entity.ObservacaoOcorrenciaEntity;

public class ObservacaoMapper {

    public ObservacaoOcorrenciaEntity toEntity(ObservacoesRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        ObservacaoOcorrenciaEntity observacao = new ObservacaoOcorrenciaEntity();
        observacao.setTitulo(dto.getTitulo());
        observacao.setDescricao(dto.getDescricao());

        return observacao;
    }

    public ObservacoesResponseDTO toDto(ObservacaoOcorrenciaEntity observacao) {
        if (observacao == null) {
            return null;
        }

        ObservacoesResponseDTO dto = new ObservacoesResponseDTO();
        dto.setId(observacao.getId());
        dto.setTitulo(observacao.getTitulo());
        dto.setDescricao(observacao.getDescricao());
        dto.setCriadoEm(observacao.getCriadoEm());

        return dto;

    }

}
