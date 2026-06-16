package com.coruja.ocorrencias.service.Validacoes;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.coruja.ocorrencias.context.Contexto;
import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.service.ValidaOcorrenciaInterface;
@Component

public class ValidaFotos implements ValidaOcorrenciaInterface {
    //Metodo que valida se a foto nao veio vazia e se veio no formato certo

    public Contexto validar(Contexto context) {

        List<MultipartFile> foto = context.getDto().getFoto();

        for (MultipartFile fotos : foto) {
            String nome = fotos.getOriginalFilename();
            if (nome == null) {
                throw new RuntimeException("Foto veio null");
            }
            String ext = nome.substring(nome.lastIndexOf(".") + 1).toLowerCase();
            if (!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png")) {
                throw new RuntimeException("Apenas arquivos JPG e PNG sao permitidos");
            }
        }
        return context;

    }
}
