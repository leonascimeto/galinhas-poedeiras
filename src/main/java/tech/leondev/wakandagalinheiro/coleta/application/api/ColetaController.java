package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakandagalinheiro.coleta.application.service.ColetaService;

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
}
