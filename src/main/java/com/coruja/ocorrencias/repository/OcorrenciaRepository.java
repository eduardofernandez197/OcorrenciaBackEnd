package com.coruja.ocorrencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coruja.ocorrencias.entity.OcorrenciaEntity;


// Repository usado para acessar e persistir ocorrencias no banco de dados.
public interface OcorrenciaRepository extends JpaRepository<OcorrenciaEntity, Long> {

     List<OcorrenciaEntity> findTop3ByOrderByCriadoEmDesc();

}
