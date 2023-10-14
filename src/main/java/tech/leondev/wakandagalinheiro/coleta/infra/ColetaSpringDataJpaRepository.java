package tech.leondev.wakandagalinheiro.coleta.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ColetaSpringDataJpaRepository extends JpaRepository<Coleta, UUID> {
    @Query("SELECT SUM(cl.quantidadeOvos) FROM coletas cl " +
            "WHERE cl.galinha = :galinha " +
            "AND cl.dataColeta >= :data")
    Integer calcularTotalOvosPorGalinhaNoIntervalo(
            @Param("galinha") Galinha galinha,
            @Param("data") LocalDate data);

    List<Coleta> findAllByDataColeta(LocalDate data);
}
