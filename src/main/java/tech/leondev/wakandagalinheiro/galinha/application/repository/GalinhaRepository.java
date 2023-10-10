package tech.leondev.wakandagalinheiro.galinha.application.repository;

import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.util.List;

public interface GalinhaRepository {
    Galinha saveGalinha(Galinha galinha);

    List<Galinha> listarGalinhas();
}
