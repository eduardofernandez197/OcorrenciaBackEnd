package com.coruja.ocorrencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coruja.ocorrencias.entity.ObservacaoOcorrenciaEntity;
    
public interface ObservacaoRepository extends JpaRepository<ObservacaoOcorrenciaEntity, Long> {

}

