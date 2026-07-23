package com.coruja.ocorrencias.service.arquivos;

import java.util.List;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;

// Interface base para componentes que processam fotos enviadas em uma observacao.
public interface SalvaFotoInterface {

    List<String> salvarFoto (ObservacoesRequestDTO foto);
    
}
