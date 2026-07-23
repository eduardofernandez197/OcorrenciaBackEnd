package com.coruja.ocorrencias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;
import com.coruja.ocorrencias.dto.response.ObservacoesResponseDTO;
import com.coruja.ocorrencias.service.OcorrenciaObservacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ocorrencias/{ocorrenciaId}/observacoes")
// Controller responsavel por cadastrar observacoes vinculadas a uma ocorrencia existente.
public class ObservacaoController {

    private final OcorrenciaObservacaoService service;

    public ObservacaoController(OcorrenciaObservacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ObservacoesResponseDTO> salvar(@PathVariable Long ocorrenciaId,
            @Valid @ModelAttribute ObservacoesRequestDTO dto) {

        ObservacoesResponseDTO response = service.salvar(ocorrenciaId, dto);

        return ResponseEntity.status(201).body(response);
    }
}
