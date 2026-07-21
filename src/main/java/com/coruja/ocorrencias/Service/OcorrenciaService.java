package com.coruja.ocorrencias.service;

import org.springframework.stereotype.Service;

import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;
import com.coruja.ocorrencias.dto.response.OcorrenciaResponseDTO;

import com.coruja.ocorrencias.entity.OcorrenciaEntity;
import com.coruja.ocorrencias.mapper.OcorrenciaMapper;
import com.coruja.ocorrencias.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

    private final OcorrenciaMapper ocorrenciaMapper;
    private final OcorrenciaRepository repository;

    public OcorrenciaService(OcorrenciaMapper ocorrenciaMapper, OcorrenciaRepository repository) {
        this.ocorrenciaMapper = ocorrenciaMapper;
        this.repository = repository;
    }

    public OcorrenciaResponseDTO salvar(OcorrenciaRequestDTO dto) {

        OcorrenciaEntity ocorrencia = ocorrenciaMapper.toEntity(dto);

        OcorrenciaEntity ocorrenciaSalva = repository.save(ocorrencia);

        OcorrenciaResponseDTO ocorrenciaResponse = ocorrenciaMapper.toDto(ocorrenciaSalva);

        return ocorrenciaResponse;

    }
}
