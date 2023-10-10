package tech.leondev.wakandagalinheiro.galinha.infra;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.util.UUID;

public interface GalinhaSpringDataJpaRepository extends JpaRepository<Galinha, UUID> {
}
