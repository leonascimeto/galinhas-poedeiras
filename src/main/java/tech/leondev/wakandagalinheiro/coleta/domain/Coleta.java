package tech.leondev.wakandagalinheiro.coleta.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaAlteraRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "coletas")
@Table(name = "coletas")
public class Coleta {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idColeta;
    @Column(name = "quantidade_ovos")
    private int quantidadeOvos;
    @NotNull
    @Column(name = "data_coleta")
    private LocalDateTime dataColeta;
    @ManyToOne
    @JoinColumn(name = "id_galinha")
    private Galinha galinha;

    public Coleta(ColetaRequestDTO coletaRequestDTO, Galinha galinha){
        this.quantidadeOvos = coletaRequestDTO.getQuantidadeOvos();
        this.dataColeta = LocalDateTime.now();
        this.galinha = galinha;
    }

    public void alteraColeta(ColetaAlteraRequestDTO coletaAlteraRequestDTO, Galinha galinha) {
        this.quantidadeOvos = coletaAlteraRequestDTO.getQuantidadeOvos();
        this.dataColeta = coletaAlteraRequestDTO.getDataColeta();
        this.galinha = galinha;
    }
}
