package com.coruja.ocorrencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coruja.ocorrencias.entity.Ocorrencia;


public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

}
