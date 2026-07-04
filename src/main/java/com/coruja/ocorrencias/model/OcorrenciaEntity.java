package com.coruja.ocorrencias.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "relatorioocorrencia")
public class OcorrenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String cliente;
    @Column(nullable = false)
    private String localizacao;
  
    private String setor;
    private String area;
    private String departamento;

    @Column(nullable = false)
    private String responsavel;
    
    @Column(name = "data_inspecao", nullable = false)
    private LocalDate data_inspecao;

    @Column(nullable = false)
    private String revisao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOcorrencia status = StatusOcorrencia.DRAFT;

     @OneToMany(mappedBy = "ocorrencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObservacaoOcorrencia> observacoes = new ArrayList<>();

    

  

}
