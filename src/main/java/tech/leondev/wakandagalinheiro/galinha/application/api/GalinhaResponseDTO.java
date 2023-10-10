package tech.leondev.wakandagalinheiro.galinha.application.api;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class GalinhaResponseDTO {
    private UUID idGalinha;
    private String name;
    private LocalDateTime dataNascimento;
}
