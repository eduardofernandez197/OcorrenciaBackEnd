package com.coruja.ocorrencias.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;
import com.coruja.ocorrencias.dto.response.OcorrenciaResponseDTO;

import com.coruja.ocorrencias.entity.OcorrenciaEntity;
import com.coruja.ocorrencias.mapper.OcorrenciaMapper;
import com.coruja.ocorrencias.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

    private OcorrenciaEntity ocorrencia;
    private OcorrenciaMapper ocorrenciaMapper;
    private OcorrenciaRepository repository;

    public OcorrenciaService(OcorrenciaEntity ocorrencia, OcorrenciaMapper ocorrenciaMapper,
            OcorrenciaRepository repository) {
        this.ocorrencia = ocorrencia;
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
