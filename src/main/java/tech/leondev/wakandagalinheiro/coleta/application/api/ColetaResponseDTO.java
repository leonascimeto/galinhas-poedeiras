package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ColetaResponseDTO {
    private UUID idColeta;
    private UUID idGalinha;
    private int quantidadeOvos;
    private LocalDate dataColeta;

    public ColetaResponseDTO(Coleta coleta) {
        this.idColeta = coleta.getIdColeta();
        this.idGalinha = coleta.getGalinha().getIdGalinha();
        this.quantidadeOvos = coleta.getQuantidadeOvos();
        this.dataColeta = coleta.getDataColeta();
    }

    public static List<ColetaResponseDTO> convertColetaList(List<Coleta> coletas) {
        return coletas.stream().map(ColetaResponseDTO::new).collect(Collectors.toList());
    }
}
