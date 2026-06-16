package com.coruja.ocorrencias.service;


import java.time.LocalDateTime;

import java.util.List;


import org.springframework.stereotype.Service;


import com.coruja.ocorrencias.context.Contexto;
import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.model.OcorrenciaEntity;
import com.coruja.ocorrencias.repository.RepositoryJPA;


@Service
public class OcorrenciaService {

    private List<ValidaOcorrenciaInterface> validacoes;
    private final RepositoryJPA repository;



    public OcorrenciaService(List<ValidaOcorrenciaInterface> validacoes, RepositoryJPA repository) {
        this.validacoes = validacoes;
        this.repository = repository;
      
       
    }

    public OcorrenciaEntity salvar(OcorrenciaDTO dto) {

        Contexto context = new Contexto(dto);

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




    public void setValidacoes(List<ValidaOcorrenciaInterface> validacoes) {
        this.validacoes = validacoes;
    }
}
