package tech.leondev.wakandagalinheiro.galinha.application.api;

import lombok.Value;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class GalinhaResponseDTO {
    private UUID idGalinha;
    private String name;
    private LocalDateTime dataNascimento;

    public GalinhaResponseDTO(Galinha galinha) {
        this.idGalinha = galinha.getIdGalinha();
        this.name = galinha.getName();
        this.dataNascimento = galinha.getDataNascimento();
    }

    public static List<GalinhaResponseDTO> convertListGalinhas(List<Galinha> galinhas) {
        return galinhas.stream().map(GalinhaResponseDTO::new).collect(Collectors.toList());
    }
}
