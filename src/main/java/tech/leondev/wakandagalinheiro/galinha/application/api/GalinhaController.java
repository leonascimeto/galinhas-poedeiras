package tech.leondev.wakandagalinheiro.galinha.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakandagalinheiro.galinha.application.service.GalinhaService;

@Log4j2
@RequiredArgsConstructor
@RestController
public class GalinhaController implements GalinhaAPI{
    private final GalinhaService galinhaService;
    @Override
    public GalinhaResponseDTO salvarGalinha(GalinhaRequestDTO galinhaRequestDTO) {
        log.info("[start] GalinhaController - salvarGalinha");
        GalinhaResponseDTO galinha = galinhaService.salvarGalinha(galinhaRequestDTO);
        log.info("[end] GalinhaController - salvarGalinha");
        return galinha;
    }
}
