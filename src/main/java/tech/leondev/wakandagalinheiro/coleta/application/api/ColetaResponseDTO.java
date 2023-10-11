package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ColetaResponseDTO {
    private UUID idColeta;
    private UUID idGalinha;
    private int quantidadeOvos;
    private LocalDateTime dataColeta;

    public ColetaResponseDTO(Coleta coleta) {
        this.idColeta = coleta.getIdColeta();
        this.idGalinha = coleta.getGalinha().getIdGalinha();
        this.quantidadeOvos = coleta.getQuantidadeOvos();
        this.dataColeta = coleta.getDataColeta();
    }
}
