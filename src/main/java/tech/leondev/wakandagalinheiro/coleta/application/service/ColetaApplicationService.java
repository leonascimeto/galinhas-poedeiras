package tech.leondev.wakandagalinheiro.coleta.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaResponseDTO;
import tech.leondev.wakandagalinheiro.coleta.application.repository.ColetaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.util.List;

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
}
