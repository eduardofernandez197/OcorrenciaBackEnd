package com.coruja.ocorrencias.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.model.OcorrenciaEntity;
import com.coruja.ocorrencias.repository.RepositoryJPA;
import com.coruja.ocorrencias.service.storage.FotoStorageService;
import com.coruja.ocorrencias.validation.ValidaOcorrenciaInterface;

@Service
public class OcorrenciaService {

    private FotoStorageService foto;
    private List<ValidaOcorrenciaInterface> validacoes;
    private final RepositoryJPA repository;

    public OcorrenciaService(FotoStorageService foto, List<ValidaOcorrenciaInterface> validacoes,
            RepositoryJPA repository) {
        this.foto = foto;
        this.validacoes = validacoes;
        this.repository = repository;
    }

    public OcorrenciaEntity salvar(OcorrenciaDTO dto) {

        validacoes.forEach(interfacevalidar -> interfacevalidar.validar(dto));
        // Para cada classe que implementar a interface ValidaOcorrencia vai fazer o
        // interfaceValidar.validar, vai executar o metodo validar dentro delas com o
        // (dto) como parametro.

        List<String> caminhos = foto.salvarCaminho(dto);

        OcorrenciaEntity entity = new OcorrenciaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setEmailDestino(dto.getEmailDestino());
        entity.setCaminhoFoto(caminhos);

        return repository.save(entity);

    }
}
