package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakandagalinheiro.coleta.application.service.ColetaService;

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
    public ColetaResponseDTO buscaColetaPeloId(UUID idColeta) {
        log.info("[start] ColetaController - buscaColetaPeloId");
        ColetaResponseDTO coleta = coletaService.buscaColetaPeloId(idColeta);
        log.info("[end] ColetaController - buscaColetaPeloId");
        return coleta;
    }

    @Override
    public void alteraColeta(ColetaRequestDTO coletaRequestDTO, UUID idColeta) {
        log.info("[start] ColetaController - updateColeta");
        coletaService.alteraColeta(coletaRequestDTO, idColeta);
        log.info("[end] ColetaController - updateColeta");
    }
}
