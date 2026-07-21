package com.coruja.ocorrencias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coruja.ocorrencias.dto.request.ObservacoesRequestDTO;
import com.coruja.ocorrencias.dto.response.ObservacoesResponseDTO;
import com.coruja.ocorrencias.entity.FotoOcorrenciaEntity;
import com.coruja.ocorrencias.entity.OcorrenciaEntity;
import com.coruja.ocorrencias.entity.ObservacaoOcorrenciaEntity;
import com.coruja.ocorrencias.exception.NotFoundException;
import com.coruja.ocorrencias.mapper.ObservacaoMapper;
import com.coruja.ocorrencias.repository.ObservacaoRepository;
import com.coruja.ocorrencias.repository.OcorrenciaRepository;
import com.coruja.ocorrencias.service.validation.validaFormatoFoto;
import com.coruja.ocorrencias.service.validation.storage.FotoStorageService;

@Service
public class OcorrenciaObservacaoService {

    private final ObservacaoMapper observacoesMapper;
    private final ObservacaoRepository observacaoRepository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final validaFormatoFoto validaFormatoFoto;
    private final FotoStorageService fotoStorageService;

    public OcorrenciaObservacaoService(ObservacaoMapper observacoesMapper,
            ObservacaoRepository observacaoRepository,
            OcorrenciaRepository ocorrenciaRepository,
            validaFormatoFoto validaFormatoFoto,
            FotoStorageService fotoStorageService) {
        this.observacoesMapper = observacoesMapper;
        this.observacaoRepository = observacaoRepository;
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.validaFormatoFoto = validaFormatoFoto;
        this.fotoStorageService = fotoStorageService;
    }

    public ObservacoesResponseDTO salvar(Long ocorrenciaId, ObservacoesRequestDTO dto) {

        OcorrenciaEntity ocorrencia = ocorrenciaRepository.findById(ocorrenciaId)
                .orElseThrow(() -> new NotFoundException("Ocorrencia nao encontrada"));

        validaFormatoFoto.salvarFoto(dto);

        ObservacaoOcorrenciaEntity observacao = observacoesMapper.toEntity(dto);
        observacao.setOcorrencia(ocorrencia);

        List<String> caminhosFotos = fotoStorageService.salvarFoto(dto);

        for (String caminhoFoto : caminhosFotos) {
            FotoOcorrenciaEntity foto = new FotoOcorrenciaEntity();
            foto.setUrlFoto(caminhoFoto);
            foto.setObservacao(observacao);
            observacao.getFotos().add(foto);
        }

        ObservacaoOcorrenciaEntity observacaoSalva = observacaoRepository.save(observacao);

        return observacoesMapper.toDto(observacaoSalva);
    }
}
