package tech.leondev.wakandagalinheiro.galinha.application.service;


import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaResponseDTO;

import java.util.List;

public interface GalinhaService {
    GalinhaResponseDTO salvarGalinha(GalinhaRequestDTO galinhaRequestDTO);

    List<GalinhaResponseDTO> listarGalinhas();
}
