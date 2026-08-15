package com.coruja.ocorrencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coruja.ocorrencias.entity.ObservacaoOcorrenciaEntity;

// Repository usado para acessar e persistir observacoes de ocorrencias no banco de dados.
public interface ObservacaoRepository extends JpaRepository<ObservacaoOcorrenciaEntity, Long> {

    List<ObservacaoOcorrenciaEntity> findByOcorrencia_Id(Long ocorrenciaId);

}

