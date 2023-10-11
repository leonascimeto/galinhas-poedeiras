package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ColetaRequestDTO {
    @NotNull
    private UUID idGalinha;
    private int quantidadeOvos;
    @NotNull
    private LocalDateTime dataColeta;
}
