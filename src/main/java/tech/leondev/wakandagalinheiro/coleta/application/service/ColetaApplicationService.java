package tech.leondev.wakandagalinheiro.coleta.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakandagalinheiro.coleta.application.api.*;
import tech.leondev.wakandagalinheiro.coleta.application.repository.ColetaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public void alteraColeta(ColetaAlteraRequestDTO coletaAlteraRequestDTO, UUID idColeta) {
        log.info("[start] ColetaApplicationService - alteraColeta");
        Coleta coleta = coletaRepository.buscaColetaPeloId(idColeta);
        Galinha galinha = galinhaRepository.buscarGalinhaPeloId(coletaAlteraRequestDTO.getIdGalinha());
        coleta.alteraColeta(coletaAlteraRequestDTO, galinha);
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
        List<Coleta> coletasPorGalinhaData = coletaRepository.findColetasPorGalinhaData(galinha, data);
        int totalOvos = this.calcularTotalOvos(coletasPorGalinhaData);
        List<ColetaResponseDTO> coletasResponse = ColetaResponseDTO.convertColetaList(coletasPorGalinhaData);
        log.info("[end] ColetaApplicationService - coletaDiariaPorGalinha");
        return new ColetaDiariaGalinhaResponseDTO(galinha, coletasResponse, totalOvos);
    }

    @Override
    public ColetaDiariaResponseDTO listColetasDiaria(LocalDate data) {
        log.info("[start] ColetaApplicationService - listColetasDiaria");
        List<Coleta> coletas = coletaRepository.findColetasPorData(data);
        int totalOvos = this.calcularTotalOvos(coletas);
        List<ColetaResponseDTO> coletasResponse = ColetaResponseDTO.convertColetaList(coletas);
        log.info("[end] ColetaApplicationService - listColetasDiaria");
        return new ColetaDiariaResponseDTO(totalOvos, coletasResponse, data);
    }

    @Override
    public ColetaIntervalResponseDTO listaColetaPorIntervalo(LocalDate dataInicio, LocalDate dataFim) {
        log.info("[start] ColetaApplicationService - listaColetaPorIntervalo");
        List<Coleta> coletas = coletaRepository.findColetasPorIntervalo(dataInicio, dataFim);
        int totalOvos = this.calcularTotalOvos(coletas);
        double mediaOvos = this.calcularMediaDiariaOvos(totalOvos, dataInicio, dataFim);
        List<ColetaResponseDTO> coletasResponse = ColetaResponseDTO.convertColetaList(coletas);
        log.info("[end] ColetaApplicationService - listaColetaPorIntervalo");
        return new ColetaIntervalResponseDTO(coletasResponse, totalOvos, mediaOvos);
    }

    public double calcularMediaDiariaOvos(int totalOvos, LocalDate dataInicio, LocalDate dataFim){
        if(totalOvos == 0) return 0.0;
        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
        return (double) totalOvos / dias;
    }

    public Integer calcularTotalOvos(List<Coleta> coletas){
        if(coletas.isEmpty()) return 0;
        return coletas.stream().mapToInt(Coleta::getQuantidadeOvos).sum();
    }
}
