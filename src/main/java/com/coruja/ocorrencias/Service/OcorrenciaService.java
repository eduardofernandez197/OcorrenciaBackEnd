package com.coruja.ocorrencias.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coruja.ocorrencias.context.Contexto;
import com.coruja.ocorrencias.model.OcorrenciaEntity;
import com.coruja.ocorrencias.repository.RepositoryJPA;
import com.coruja.ocorrencias.service.Validacoes.ValidaSalvafoto;

@Service
public class OcorrenciaService {

    private List<ValidaOcorrenciaInterface> validacoes;
    private final RepositoryJPA repository;
    private final ValidaSalvafoto validaFoto;

   
    public OcorrenciaService(List<ValidaOcorrenciaInterface> validacoes, RepositoryJPA repository,
            ValidaSalvafoto validaFoto) {
        this.validacoes = validacoes;
        this.repository = repository;
        this.validaFoto = validaFoto;
    }


    public OcorrenciaEntity salvar(Contexto context) {

        validacoes.forEach(interfacevalidar -> interfacevalidar.validar(context));
        // Para cada classe que implementar a interface ValidaOcorrencia vai fazer o
        // interfaceValidar.validar, vai executar o metodo validar dentro delas com o
        // (dto) como parametro.

       

        OcorrenciaEntity entity = new OcorrenciaEntity();
        entity.setTitulo(context.getDto().getTitulo());
        entity.setDescricao(context.getDto().getDescricao());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setEmailDestino(context.getDto().getEmailDestino());
        entity.setCaminhoFoto(context.getCaminhos());

        return repository.save(entity);

    }
}
