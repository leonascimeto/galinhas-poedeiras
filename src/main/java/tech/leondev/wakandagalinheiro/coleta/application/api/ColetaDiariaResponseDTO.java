package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class ColetaDiariaResponseDTO {
    private LocalDate data;
    private Integer totalOvos;
    private List<ColetaResponseDTO> coletas;

    public ColetaDiariaResponseDTO(int totalOvos, List<ColetaResponseDTO> coletasResponse, LocalDate data) {
        this.data = data;
        this.totalOvos = totalOvos;
        this.coletas = coletasResponse;
    }
}
