package tech.leondev.wakandagalinheiro.galinha.application.service;


import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaResponseDTO;

import java.util.List;
import java.util.UUID;

public interface GalinhaService {
    GalinhaResponseDTO salvarGalinha(GalinhaRequestDTO galinhaRequestDTO);

    List<GalinhaResponseDTO> listarGalinhas();

    GalinhaResponseDTO buscarGalinhaPeloId(UUID idGalinha);
}
