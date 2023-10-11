package tech.leondev.wakandagalinheiro.coleta.application.repository;

import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;

import java.util.List;
import java.util.UUID;

public interface ColetaRepository {
    Coleta salvarColeta(Coleta coleta);

    List<Coleta> listaColetas();

    Coleta buscaColetaPeloId(UUID idColeta);
}
