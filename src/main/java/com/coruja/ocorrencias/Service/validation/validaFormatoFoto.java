package com.coruja.ocorrencias.service.validation;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;
import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;
import com.coruja.ocorrencias.exception.BusinessException;
import com.coruja.ocorrencias.service.arquivos.SalvaFotoInterface;
@Component

public class validaFormatoFoto implements SalvaFotoInterface {
    //Metodo que valida se a foto nao veio vazia e se veio no formato certo

    public ObservacoesRequestDTO salvarFoto(ObservacoesRequestDTO dto) {

        List<MultipartFile> foto = dto.getImagens();

        for (MultipartFile fotos : foto) {
            String nome = fotos.getOriginalFilename();
            if (nome == null) {
                throw new BusinessException("Foto veio null");
            }
            String ext = nome.substring(nome.lastIndexOf(".") + 1).toLowerCase();
            if (!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png")) {
                throw new BusinessException("Apenas arquivos JPG e PNG sao permitidos");
            }
        }
        return dto;

    }
}
