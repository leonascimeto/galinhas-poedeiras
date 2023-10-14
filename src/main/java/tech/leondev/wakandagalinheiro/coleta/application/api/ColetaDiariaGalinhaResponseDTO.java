package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.Value;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ColetaDiariaGalinhaResponseDTO {
    private UUID idGalinha;
    private String nameGalinha;
    private int totalOvos;

    public ColetaDiariaGalinhaResponseDTO(Galinha galinha, int totalOvos) {
        this.idGalinha = galinha.getIdGalinha();
        this.nameGalinha = galinha.getName();
        this.totalOvos = totalOvos;
    }
}
