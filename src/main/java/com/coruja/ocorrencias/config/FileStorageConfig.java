package com.coruja.ocorrencias.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
// Configuracao que le o diretorio onde os arquivos enviados serao armazenados.
public class FileStorageConfig {

    @Value("${upload.dir}")
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }
}

