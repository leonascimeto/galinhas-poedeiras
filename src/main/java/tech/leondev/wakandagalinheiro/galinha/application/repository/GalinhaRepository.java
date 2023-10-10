package tech.leondev.wakandagalinheiro.galinha.application.repository;

import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.util.List;
import java.util.UUID;

public interface GalinhaRepository {
    Galinha salvarGalinha(Galinha galinha);

    List<Galinha> listarGalinhas();

    Galinha buscarGalinhaPeloId(UUID idGalinha);
}
