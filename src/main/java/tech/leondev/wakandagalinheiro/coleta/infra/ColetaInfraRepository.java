package tech.leondev.wakandagalinheiro.coleta.infra;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import tech.leondev.wakandagalinheiro.coleta.application.repository.ColetaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;
import tech.leondev.wakandagalinheiro.handler.ApiException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ColetaInfraRepository implements ColetaRepository {
    private final ColetaSpringDataJpaRepository coletaSpringDataJpaRepository;
    private final EntityManager entityManager;

    @Override
    public Coleta salvarColeta(Coleta coleta) {
        log.info("[start] ColetaInfraRepository - salvarColeta");
        Coleta novaColeta = coletaSpringDataJpaRepository.save(coleta);
        log.info("[end] ColetaInfraRepository - salvarColeta");
        return novaColeta;
    }

    @Override
    public List<Coleta> listaColetas() {
        log.info("[start] ColetaInfraRepository - listaColetas");
        List<Coleta> coletas = coletaSpringDataJpaRepository.findAll();
        log.info("[end] ColetaInfraRepository - listaColetas");
        return coletas;
    }

    @Override
    public Coleta buscaColetaPeloId(UUID idColeta) {
        log.info("[start] ColetaInfraRepository - buscaColetaPeloId");
        Coleta coleta = coletaSpringDataJpaRepository.findById(idColeta)
                        .orElseThrow(() -> ApiException.build(HttpStatus.BAD_REQUEST, "Coleta não encontrada"));
        log.info("[end] ColetaInfraRepository - buscaColetaPeloId");
        return coleta;
    }

    @Override
    public void deletaColeta(Coleta coleta) {
        log.info("[start] ColetaInfraRepository - buscaColetaPeloId");
        coletaSpringDataJpaRepository.delete(coleta);
        log.info("[end] ColetaInfraRepository - buscaColetaPeloId");
    }

    @Override
    public List<Coleta> findColetasPorData(LocalDate data) {
        log.info("[start] ColetaInfraRepository - findColetasPorData");
        List<Coleta> coletas = coletaSpringDataJpaRepository.findAllByDataColeta(data);
        log.info("[end] ColetaInfraRepository - findColetasPorData");
        return coletas;
    }

    @Override
    public List<Coleta> findColetasPorGalinhaData(Galinha galinha, LocalDate data) {
        log.info("[start] ColetaInfraRepository - findColetasPorData");
        List<Coleta> coletas = coletaSpringDataJpaRepository.findAllByGalinhaAndDataColeta(galinha, data);
        log.info("[end] ColetaInfraRepository - findColetasPorData");
        return coletas;
    }

    @Override
    public List<Coleta> findColetasPorIntervalo(LocalDate dataInicio, LocalDate dataFim) {
        log.info("[start] ColetaInfraRepository - findColetasPorIntervalo");
        List<Coleta> coletas = coletaSpringDataJpaRepository.findAllByDataColetaBetween(dataInicio, dataFim);
        log.info("[end] ColetaInfraRepository - findColetasPorIntervalo");
        return coletas;
    }
}
