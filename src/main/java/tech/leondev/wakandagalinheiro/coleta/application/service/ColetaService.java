package tech.leondev.wakandagalinheiro.coleta.application.service;


import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaResponseDTO;

public interface ColetaService {

    ColetaResponseDTO salvaColeta(ColetaRequestDTO coletaRequestDTO);
}
