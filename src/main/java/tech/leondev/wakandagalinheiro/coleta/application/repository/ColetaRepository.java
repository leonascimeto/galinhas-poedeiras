package tech.leondev.wakandagalinheiro.coleta.application.repository;

import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ColetaRepository {
    Coleta salvarColeta(Coleta coleta);

    List<Coleta> listaColetas();

    Coleta buscaColetaPeloId(UUID idColeta);

    void deletaColeta(Coleta coleta);

    List<Coleta> findColetasPorData(LocalDate data);

    List<Coleta> findColetasPorGalinhaData(Galinha galinha, LocalDate data);

    List<Coleta> findColetasPorIntervalo(LocalDate dataInicio, LocalDate dataFim);
}
