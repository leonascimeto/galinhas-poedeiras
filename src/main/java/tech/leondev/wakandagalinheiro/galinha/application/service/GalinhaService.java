package tech.leondev.wakandagalinheiro.galinha.application.service;


import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaResponseDTO;

public interface GalinhaService {
    GalinhaResponseDTO salvarGalinha(GalinhaRequestDTO galinhaRequestDTO);
}
