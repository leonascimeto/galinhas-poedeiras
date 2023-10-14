package tech.leondev.wakandagalinheiro.galinha.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity(name = "galinhas")
@Table(name = "galinhas")
public class Galinha {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private UUID idGalinha;
    @NotBlank
    private String name;
    @NotNull
    private LocalDateTime dataNascimento;

    public Galinha(GalinhaRequestDTO galinhaRequestDTO){
        this.name = galinhaRequestDTO.getName();
        this.dataNascimento = galinhaRequestDTO.getDataNascimento();
    }

    public void alteraGalinha(GalinhaRequestDTO galinhaRequestDTO) {
        this.name = galinhaRequestDTO.getName();
        this.dataNascimento = galinhaRequestDTO.getDataNascimento();
    }
}
