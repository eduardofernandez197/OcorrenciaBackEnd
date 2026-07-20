package com.coruja.ocorrencias.service.arquivos;

import java.util.List;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;

public interface SalvaFotoInterface {

    List<String> salvarFoto (ObservacoesRequestDTO foto);
    
}
