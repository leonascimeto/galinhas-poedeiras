package tech.leondev.wakandagalinheiro.coleta.application.repository;

import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ColetaRepository {
    Coleta salvarColeta(Coleta coleta);

    List<Coleta> listaColetas();

    Coleta buscaColetaPeloId(UUID idColeta);

    void deletaColeta(Coleta coleta);

    int totalOvosDiarioPorGalinha(Galinha galinha, LocalDateTime dataInicial, LocalDateTime dataFinal);
}
