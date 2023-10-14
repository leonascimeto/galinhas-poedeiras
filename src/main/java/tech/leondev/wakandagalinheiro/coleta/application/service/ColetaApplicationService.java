package tech.leondev.wakandagalinheiro.coleta.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaDiariaGalinhaResponseDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaResponseDTO;
import tech.leondev.wakandagalinheiro.coleta.application.repository.ColetaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Log4j2
@Service
public class ColetaApplicationService implements ColetaService{
    private final ColetaRepository coletaRepository;
    private final GalinhaRepository galinhaRepository;

    @Override
    public ColetaResponseDTO salvaColeta(ColetaRequestDTO coletaRequestDTO) {
        log.info("[start] ColetaApplicationService - salvaColeta");
        Galinha galinha = galinhaRepository.buscarGalinhaPeloId(coletaRequestDTO.getIdGalinha());
        Coleta coleta = coletaRepository.salvarColeta(new Coleta(coletaRequestDTO, galinha));
        log.info("[end] ColetaApplicationService - salvaColeta");
        return new ColetaResponseDTO(coleta);
    }

    @Override
    public List<ColetaResponseDTO> listaColetas() {
        log.info("[start] ColetaApplicationService - listaColetas");
        List<Coleta> coletas = coletaRepository.listaColetas();
        log.info("[end] ColetaApplicationService - listaColetas");
        return ColetaResponseDTO.convertColetaList(coletas);
    }

    @Override
    public ColetaResponseDTO buscaColetaPeloId(UUID idColeta) {
        log.info("[start] ColetaApplicationService - buscaColetaPeloId");
        Coleta coleta = coletaRepository.buscaColetaPeloId(idColeta);
        log.info("[end] ColetaApplicationService - buscaColetaPeloId");
        return new ColetaResponseDTO(coleta);
    }

    @Override
    public void alteraColeta(ColetaRequestDTO coletaRequestDTO, UUID idColeta) {
        log.info("[start] ColetaApplicationService - alteraColeta");
        Coleta coleta = coletaRepository.buscaColetaPeloId(idColeta);
        Galinha galinha = galinhaRepository.buscarGalinhaPeloId(coletaRequestDTO.getIdGalinha());
        coleta.alteraColeta(coletaRequestDTO, galinha);
        coletaRepository.salvarColeta(coleta);
        log.info("[end] ColetaApplicationService - alteraColeta");
    }

    @Override
    public void deletaColeta(UUID idColeta) {
        log.info("[start] ColetaApplicationService - deletaColeta");
        Coleta coleta = coletaRepository.buscaColetaPeloId(idColeta);
        coletaRepository.deletaColeta(coleta);
        log.info("[end] ColetaApplicationService - deletaColeta");

    }

    @Override
    public ColetaDiariaGalinhaResponseDTO coletaDiariaPorGalinha(UUID idGalinha, LocalDate data) {
        log.info("[start] ColetaApplicationService - coletaDiariaPorGalinha");
        Galinha galinha = galinhaRepository.buscarGalinhaPeloId(idGalinha);
        LocalDateTime dataInicial = data.atStartOfDay();
        LocalDateTime dataFinal = data.atTime(LocalTime.MAX);
        int totalOvos = coletaRepository.totalOvosDiarioPorGalinha(galinha, dataInicial, dataFinal);
        log.info("[end] ColetaApplicationService - coletaDiariaPorGalinha");
        return new ColetaDiariaGalinhaResponseDTO(galinha, totalOvos);
    }
}
