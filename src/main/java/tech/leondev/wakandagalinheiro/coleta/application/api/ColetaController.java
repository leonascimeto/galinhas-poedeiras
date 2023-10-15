package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakandagalinheiro.coleta.application.service.ColetaService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ColetaController implements ColetaAPI{
    private final ColetaService coletaService;
    @Override
    public ColetaResponseDTO salvarColeta(ColetaRequestDTO coletaRequestDTO) {
        log.info("[start] ColetaController - salvarColeta");
        ColetaResponseDTO coleta = coletaService.salvaColeta(coletaRequestDTO);
        log.info("[end] ColetaController - salvarColeta");
        return coleta;
    }

    @Override
    public List<ColetaResponseDTO> listaColetas() {
        log.info("[start] ColetaController - listaColetas");
        List<ColetaResponseDTO> coletas = coletaService.listaColetas();
        log.info("[end] ColetaController - listaColetas");
        return coletas;
    }

    @Override
    public ColetaDiariaGalinhaResponseDTO coletaDiariaPorGalinha(UUID idGalinha, LocalDate data) {
        log.info("[start] ColetaController - totalColetaPorGalinhaPorData");
        ColetaDiariaGalinhaResponseDTO coletaDiariaPorGalinha = coletaService.coletaDiariaPorGalinha(idGalinha, data);
        log.info("[end] ColetaController - totalColetaPorGalinhaPorData");
        return coletaDiariaPorGalinha;
    }

    @Override
    public ColetaDiariaResponseDTO listColetasPorData(LocalDate data) {
        log.info("[start] ColetaController - listColetasDiaria");
        ColetaDiariaResponseDTO coletaDiariaResponseDTO = coletaService.listColetasDiaria(data);
        log.info("[end] ColetaController - listColetasDiaria");
        return coletaDiariaResponseDTO;
    }

    @Override
    public ColetaResponseDTO buscaColetaPeloId(UUID idColeta) {
        log.info("[start] ColetaController - buscaColetaPeloId");
        ColetaResponseDTO coleta = coletaService.buscaColetaPeloId(idColeta);
        log.info("[end] ColetaController - buscaColetaPeloId");
        return coleta;
    }

    @Override
    public ColetaIntervalResponseDTO buscarColetaPorIntervalo(LocalDate dataInicio, LocalDate dataFim) {
        log.info("[start] ColetaController - buscarColetaPorIntervalo");
        ColetaIntervalResponseDTO coletas = coletaService.listaColetaPorIntervalo(dataInicio, dataFim);
        log.info("[end] ColetaController - buscarColetaPorIntervalo");
        return coletas;
    }

    @Override
    public void alteraColeta(ColetaAlteraRequestDTO coletaAlteraRequestDTO, UUID idColeta) {
        log.info("[start] ColetaController - updateColeta");
        coletaService.alteraColeta(coletaAlteraRequestDTO, idColeta);
        log.info("[end] ColetaController - updateColeta");
    }

    @Override
    public void deletaColeta(UUID idColeta) {
        log.info("[start] ColetaController - deletaColeta");
        coletaService.deletaColeta(idColeta);
        log.info("[end] ColetaController - deletaColeta");

    }
}
