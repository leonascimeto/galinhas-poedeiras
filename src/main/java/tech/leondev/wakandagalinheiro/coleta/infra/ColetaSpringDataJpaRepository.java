package tech.leondev.wakandagalinheiro.coleta.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ColetaSpringDataJpaRepository extends JpaRepository<Coleta, UUID> {
    List<Coleta> findAllByDataColeta(LocalDate data);

    List<Coleta> findAllByGalinhaAndDataColeta(Galinha galinha, LocalDate data);

    List<Coleta> findAllByDataColetaBetween(LocalDate dataInicio, LocalDate dataFim);
}
