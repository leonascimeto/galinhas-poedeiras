package tech.leondev.wakandagalinheiro.coleta.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;

import java.util.UUID;

public interface ColetaSpringDataJpaRepository extends JpaRepository<Coleta, UUID> {
}
