package tech.leondev.wakandagalinheiro.coleta.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import tech.leondev.wakandagalinheiro.coleta.application.repository.ColetaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.handler.ApiException;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class ColetaInfraRepository implements ColetaRepository {
    private final ColetaSpringDataJpaRepository coletaSpringDataJpaRepository;
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
}
