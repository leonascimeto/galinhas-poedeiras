package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.Value;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.util.List;
import java.util.UUID;

@Value
public class ColetaDiariaGalinhaResponseDTO {
    private int totalOvos;
    private UUID idGalinha;
    private String nameGalinha;
    private List<ColetaResponseDTO> coletas;

    public ColetaDiariaGalinhaResponseDTO(Galinha galinha, List<ColetaResponseDTO> coletasPorGalinhaData, int totalOvos) {
        this.idGalinha = galinha.getIdGalinha();
        this.nameGalinha = galinha.getName();
        this.totalOvos = totalOvos;
        this.coletas = coletasPorGalinhaData;
    }
}
