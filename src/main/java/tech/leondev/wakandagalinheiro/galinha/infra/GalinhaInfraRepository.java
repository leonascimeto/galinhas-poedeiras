package tech.leondev.wakandagalinheiro.galinha.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;
import tech.leondev.wakandagalinheiro.handler.ApiException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Repository
public class GalinhaInfraRepository implements GalinhaRepository {
    private final GalinhaSpringDataJpaRepository galinhaSpringDataJpaRepository;
    @Override
    public Galinha salvarGalinha(Galinha galinha) {
        log.info("[start] GalinhaInfraRepository - saveGalinha");
        Galinha novaGalinha = galinhaSpringDataJpaRepository.save(galinha);
        log.info("[end] GalinhaInfraRepository - saveGalinha");
        return novaGalinha;
    }

    @Override
    public List<Galinha> listarGalinhas() {
        log.info("[start] GalinhaInfraRepository - listarGalinhas");
        List<Galinha> galinhas = galinhaSpringDataJpaRepository.findAll();
        log.info("[end] GalinhaInfraRepository - listarGalinhas");
        return galinhas;
    }

    @Override
    public Galinha buscarGalinhaPeloId(UUID idGalinha) {
        log.info("[start] GalinhaInfraRepository - buscarGalinhaPeloId");
        Galinha galinha = galinhaSpringDataJpaRepository.findById(idGalinha)
                .orElseThrow(() -> ApiException.build(HttpStatus.BAD_REQUEST, "Galinha não encontrada"));
        log.info("[end] GalinhaInfraRepository - buscarGalinhaPeloId");
        return galinha;
    }

    @Override
    public void deletaGalinha(Galinha galinha) {
        log.info("[start] GalinhaInfraRepository - deletaGalinha");
        galinhaSpringDataJpaRepository.delete(galinha);
        log.info("[end] GalinhaInfraRepository - deletaGalinha");
    }
}
