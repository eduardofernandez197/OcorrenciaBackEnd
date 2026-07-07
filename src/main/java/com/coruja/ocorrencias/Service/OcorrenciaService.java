package com.coruja.ocorrencias.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;
import com.coruja.ocorrencias.dto.response.OcorrenciaResponseDTO;
import com.coruja.ocorrencias.entity.Ocorrencia;
import com.coruja.ocorrencias.mapper.OcorrenciaMapper;
import com.coruja.ocorrencias.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {
    
    private Ocorrencia ocorrencia;
    private OcorrenciaMapper ocorrenciaMapper;

    
    public OcorrenciaService(Ocorrencia ocorrencia, OcorrenciaMapper ocorrenciaMapper) {
        this.ocorrencia = ocorrencia;
        this.ocorrenciaMapper = ocorrenciaMapper;
    }
    public OcorrenciaResponseDTO salvar (OcorrenciaRequestDTO dto) {

            Ocorrencia ocorrencia = ocorrenciaMapper.toEntity(dto);
            



        return save();

}}
