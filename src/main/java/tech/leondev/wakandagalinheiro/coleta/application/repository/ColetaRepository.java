package tech.leondev.wakandagalinheiro.coleta.application.repository;

import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;

import java.util.List;

public interface ColetaRepository {
    Coleta salvarColeta(Coleta coleta);

    List<Coleta> listaColetas();
}
