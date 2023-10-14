package tech.leondev.wakandagalinheiro;

import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DataHelper {
    public static final UUID GALINHA_ID = UUID.fromString("aa2d3178-ea30-4726-82fb-3be22f0da36d");
    public static final String GALINHA_NOME = "penelope";
    public static final LocalDateTime GALINHA_DATA_NASCIMENTO = LocalDateTime.of(2023, 1, 15, 6, 30);
    public static final String GALINHA_NOME_ALTERADO = "julia";
    public static final LocalDateTime GALINHA_DATA_NASCIMENTO_ALTERADO = LocalDateTime.of(2023, 1, 12, 6, 30);

    public static Galinha gerarGalinha(){
        return Galinha.builder()
                .idGalinha(GALINHA_ID)
                .name(GALINHA_NOME)
                .dataNascimento(GALINHA_DATA_NASCIMENTO)
                .build();
    }

    public static GalinhaRequestDTO requestSalvaGalinha(Galinha galinha){
        return new GalinhaRequestDTO(galinha.getName(), galinha.getDataNascimento());
    }

    public static GalinhaRequestDTO requestAlteraGalinha(){
        return new GalinhaRequestDTO(GALINHA_NOME_ALTERADO, GALINHA_DATA_NASCIMENTO_ALTERADO);
    }

    public static List<Galinha> gerarListaGalinhas(){
        return List.of(
                Galinha.builder().idGalinha(UUID.randomUUID()).name("gertrude").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("maria").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("carla").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("clarice").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("penelope").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("milena").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("larissa").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("amanda").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("liliana").dataNascimento(LocalDateTime.now()).build(),
                Galinha.builder().idGalinha(UUID.randomUUID()).name("roberta").dataNascimento(LocalDateTime.now()).build()
        );
    }
}
