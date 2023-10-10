package tech.leondev.wakandagalinheiro.coleta.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private UUID idColeta;
    @Column(name = "quantidade_ovos")
    private int quantidadeOvos;
    @NotNull
    @Column(name = "data_coleta")
    private LocalDateTime dataColeta;
    @ManyToOne
    @JoinColumn(name = "id_galinha")
    private Galinha galinha;
}
