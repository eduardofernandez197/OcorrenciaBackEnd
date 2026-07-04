package com.coruja.ocorrencias.service.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.coruja.ocorrencias.config.FileStorageConfig;
import com.coruja.ocorrencias.dto.request.OcorrenciaRequestDTO;

import jakarta.validation.ValidationException;

@Component
public class FotoStorageService {

    private FileStorageConfig file;

    public FotoStorageService(FileStorageConfig file) {
        this.file = file;
    }

    public List<String> salvarCaminho (OcorrenciaRequestDTO dto) {

        List<String> caminhos = new ArrayList<>();

        Path pastaUpload = Path.of(file.getUploadDir());

        try {
            for (MultipartFile caminhofotos : dto.getFoto()) {
                Files.createDirectories(pastaUpload);

                String caminho = caminhofotos.getOriginalFilename();

                String nomeOriginal = UUID.randomUUID() + "-" + caminho;

                Path destino = pastaUpload.resolve(nomeOriginal);

                caminhofotos.transferTo(destino);

                caminhos.add("ocorrencias/" + nomeOriginal);
            }

        } catch (IOException e) {
            throw new ValidationException("Erro ao salvar foto na pasta upload - local", e);
        }
        return caminhos;

    }
}
