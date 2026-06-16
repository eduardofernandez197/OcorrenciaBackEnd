package com.coruja.ocorrencias.context;

import java.util.ArrayList;
import java.util.List;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;

public class Contexto {

private OcorrenciaDTO dto;
private List<String> caminhos = new ArrayList<>();

public Contexto(OcorrenciaDTO dto) {
    this.dto = dto;
}
public OcorrenciaDTO getDto() {
    return dto;
}
public void setDto(OcorrenciaDTO dto) {
    this.dto = dto;
}
public List<String> getCaminhos() {
    return caminhos;
}
public void setCaminhos(List<String> caminhos) {
    this.caminhos = caminhos;
}



    
}
