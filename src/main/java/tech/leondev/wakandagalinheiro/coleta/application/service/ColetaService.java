package tech.leondev.wakandagalinheiro.coleta.application.service;


import tech.leondev.wakandagalinheiro.coleta.application.api.*;

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

    ColetaDiariaResponseDTO listColetasDiaria(LocalDate data);

    ColetaIntervalResponseDTO listaColetaPorIntervalo(LocalDate dataInicio, LocalDate dataFim);
}
