package com.coruja.ocorrencias.service.arquivos;

import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;

// Interface base para classes que validam dados de uma ocorrencia.
public interface ValidaOcorrenciaInterface {

OcorrenciaRequestDTO validar(OcorrenciaRequestDTO dto);
     
}
