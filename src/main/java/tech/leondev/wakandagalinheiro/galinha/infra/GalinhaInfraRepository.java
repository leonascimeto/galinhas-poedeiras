package tech.leondev.wakandagalinheiro.galinha.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

@RequiredArgsConstructor
@Log4j2
@Repository
public class GalinhaInfraRepository implements GalinhaRepository {
    private final GalinhaSpringDataJpaRepository galinhaSpringDataJpaRepository;
    @Override
    public Galinha saveGalinha(Galinha galinha) {
        log.info("[start] GalinhaInfraRepository - saveGalinha");
        Galinha novaGalinha = galinhaSpringDataJpaRepository.save(galinha);
        log.info("[end] GalinhaInfraRepository - saveGalinha");
        return novaGalinha;
    }
}
