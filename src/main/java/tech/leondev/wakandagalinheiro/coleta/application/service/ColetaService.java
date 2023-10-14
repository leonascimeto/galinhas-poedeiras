package tech.leondev.wakandagalinheiro.coleta.application.service;


import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaAlteraRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaDiariaGalinhaResponseDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ColetaService {

    ColetaResponseDTO salvaColeta(ColetaRequestDTO coletaRequestDTO);

    List<ColetaResponseDTO> listaColetas();

    ColetaResponseDTO buscaColetaPeloId(UUID idColeta);

    void alteraColeta(ColetaAlteraRequestDTO coletaAlteraRequestDTO, UUID idColeta);

    void deletaColeta(UUID idColeta);

    ColetaDiariaGalinhaResponseDTO coletaDiariaPorGalinha(UUID idGalinha, LocalDate data);
}
