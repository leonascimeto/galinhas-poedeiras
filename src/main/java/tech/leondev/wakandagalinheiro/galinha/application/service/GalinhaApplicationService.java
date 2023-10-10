package tech.leondev.wakandagalinheiro.galinha.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaResponseDTO;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class GalinhaApplicationService implements GalinhaService{
    private final GalinhaRepository galinhaRepository;
    @Override
    public GalinhaResponseDTO salvarGalinha(GalinhaRequestDTO galinhaRequestDTO) {
        log.info("[start] GalinhaApplicationService - salvarGalinha");
        Galinha galinha = galinhaRepository.saveGalinha(new Galinha(galinhaRequestDTO));
        log.info("[start] GalinhaApplicationService - salvarGalinha");
        return new GalinhaResponseDTO(galinha);
    }

    @Override
    public List<GalinhaResponseDTO> listarGalinhas() {
        log.info("[start] GalinhaApplicationService - listarGalinhas");
        List<Galinha> galinhas = galinhaRepository.listarGalinhas();
        log.info("[end] GalinhaApplicationService - listarGalinhas");
        return GalinhaResponseDTO.convertListGalinhas(galinhas);
    }

    @Override
    public GalinhaResponseDTO buscarGalinhaPeloId(UUID idGalinha) {
        log.info("[start] GalinhaApplicationService - buscarGalinhaPeloId");
        Galinha galinha = galinhaRepository.buscarGalinhaPeloId(idGalinha);
        log.info("[end] GalinhaApplicationService - buscarGalinhaPeloId");
        return new GalinhaResponseDTO(galinha);
    }
}
