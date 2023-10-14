package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ColetaAlteraRequestDTO {
    @NotNull
    private UUID idGalinha;
    private int quantidadeOvos;
    @NotNull
    private LocalDate dataColeta;
}
