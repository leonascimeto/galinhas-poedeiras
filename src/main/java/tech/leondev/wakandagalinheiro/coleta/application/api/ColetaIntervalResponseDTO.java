package tech.leondev.wakandagalinheiro.coleta.application.api;

import lombok.Value;

import java.util.List;

@Value
public class ColetaIntervalResponseDTO {
    private int totalOvos;
    private double mediaOvosPorDia;
    private List<ColetaResponseDTO> coletas;

    public ColetaIntervalResponseDTO(List<ColetaResponseDTO> coletasResponse, int totalOvos, double mediaOvos) {
        this.totalOvos = totalOvos;
        this.mediaOvosPorDia = mediaOvos;
        this.coletas = coletasResponse;
    }
}
