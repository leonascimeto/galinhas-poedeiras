package tech.leondev.wakandagalinheiro.coleta.application.service;


import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ColetaService {

    ColetaResponseDTO salvaColeta(ColetaRequestDTO coletaRequestDTO);

    List<ColetaResponseDTO> listaColetas();

    ColetaResponseDTO buscaColetaPeloId(UUID idColeta);

    void alteraColeta(ColetaRequestDTO coletaRequestDTO, UUID idColeta);
}
