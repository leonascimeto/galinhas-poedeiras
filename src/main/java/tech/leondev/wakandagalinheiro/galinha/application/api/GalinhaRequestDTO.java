package tech.leondev.wakandagalinheiro.galinha.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class GalinhaRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    private LocalDateTime dataNascimento;
}
