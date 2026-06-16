package com.coruja.ocorrencias.service.Validacoes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.coruja.ocorrencias.context.Contexto;
import com.coruja.ocorrencias.service.ValidaOcorrenciaInterface;

@Component
public class ValidaSalvafoto implements ValidaOcorrenciaInterface {

    public Contexto validar(Contexto context) {

        List<String> caminhos = new ArrayList<>();

        Path pastaUpload = Path.of("upload");

        try {
            for (MultipartFile caminhofotos : context.getDto().getFoto()) {
                Files.createDirectories(pastaUpload);

                String caminho = caminhofotos.getOriginalFilename();

                String nomeOriginal = UUID.randomUUID() + "-" + caminho;

                Path destino = pastaUpload.resolve(nomeOriginal);

                caminhofotos.transferTo(destino);

                caminhos.add("ocorrencias" + nomeOriginal);
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar foto na pasta upload - local", e);
        }

        context.setCaminhos(caminhos);

        return context;
    }
}
