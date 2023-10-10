package tech.leondev.wakandagalinheiro.galinha.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import tech.leondev.wakandagalinheiro.galinha.application.service.GalinhaService;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<GalinhaResponseDTO> listarGalinhas() {
        log.info("[start] GalinhaController - listarGalinhas");
        List<GalinhaResponseDTO> galinhas = galinhaService.listarGalinhas();
        log.info("[end] GalinhaController - listarGalinhas");
        return galinhas;
    }

    @Override
    public GalinhaResponseDTO buscarGalinhaPeloId(UUID idGalinha) {
        log.info("[start] GalinhaController - buscarGalinhaPeloId");
        GalinhaResponseDTO galinha = galinhaService.buscarGalinhaPeloId(idGalinha);
        log.info("[end] GalinhaController - buscarGalinhaPeloId");
        return galinha;
    }

    @Override
    public void alterarGalinha(UUID idGalinha, GalinhaRequestDTO galinhaRequestDTO) {
        log.info("[start] GalinhaController - alterarGalinha");
        galinhaService.alterarGalinha(idGalinha, galinhaRequestDTO);
        log.info("[end] GalinhaController - alterarGalinha");
    }
}
