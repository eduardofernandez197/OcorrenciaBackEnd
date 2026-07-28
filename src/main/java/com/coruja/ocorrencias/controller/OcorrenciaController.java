package com.coruja.ocorrencias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;
import com.coruja.ocorrencias.dto.response.OcorrenciaResponseDTO;
import com.coruja.ocorrencias.service.OcorrenciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/upload")
// Controller responsavel por receber os dados principais da ocorrencia e criar o registro inicial.
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OcorrenciaResponseDTO> salvar(@Valid @ModelAttribute OcorrenciaRequestDTO dto) {

        OcorrenciaResponseDTO response = service.salvar(dto);

        return ResponseEntity.status(201).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaResponseDTO> buscarPorId(@PathVariable Long id) {

        OcorrenciaResponseDTO response = service.buscarPorId(id);

        return ResponseEntity.ok(response);

    }

}
