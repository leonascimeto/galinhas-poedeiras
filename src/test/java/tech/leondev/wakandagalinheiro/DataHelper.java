package tech.leondev.wakandagalinheiro;

import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaAlteraRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.application.api.ColetaRequestDTO;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DataHelper {
    public static final UUID GALINHA_ID = UUID.fromString("aa2d3178-ea30-4726-82fb-3be22f0da36d");
    public static final String GALINHA_NOME = "penelope";
    public static final LocalDateTime GALINHA_DATA_NASCIMENTO = LocalDateTime.of(2023, 1, 15, 6, 30);
    public static final String GALINHA_NOME_ALTERADO = "julia";
    public static final LocalDateTime GALINHA_DATA_NASCIMENTO_ALTERADO = LocalDateTime.of(2023, 1, 12, 6, 30);

    public static final UUID COLETA_ID = UUID.fromString("9671fc6a-5b56-41d6-8bde-61fe09d25f81");
    public static LocalDate COLETA_DATA = LocalDate.of(2023, 10, 14);
    public static LocalDate COLETA_DATA_2 = LocalDate.of(2023, 10, 15);
    public static LocalDate COLETA_DATA_ALTERADO = LocalDate.of(2023, 9, 14);

    public static Coleta gerarColeta(){
        return Coleta.builder()
                .idColeta(COLETA_ID)
                .dataColeta(COLETA_DATA)
                .quantidadeOvos(4)
                .galinha(DataHelper.gerarGalinha())
                .build();
    }

    public static ColetaRequestDTO requestSalvaColeta(Coleta coleta){
        return new ColetaRequestDTO(coleta.getGalinha().getIdGalinha(), coleta.getQuantidadeOvos());
    }

    public static ColetaAlteraRequestDTO requestAlteraColeta(){
        return new ColetaAlteraRequestDTO(GALINHA_ID, 100, COLETA_DATA_ALTERADO);
    }

    public static List<Coleta> gerarListaColeta(){
        Galinha galinha = DataHelper.gerarGalinha();
        return List.of(
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA).quantidadeOvos(2).galinha(galinha).build(),
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA).quantidadeOvos(1).galinha(galinha).build(),
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA).quantidadeOvos(3).galinha(galinha).build()
                );
    }

    public static List<Coleta> gerarListaColetaParaMedia(){
        Galinha galinha = DataHelper.gerarGalinha();
        return List.of(
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA).quantidadeOvos(2).galinha(galinha).build(),
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA).quantidadeOvos(1).galinha(galinha).build(),
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA).quantidadeOvos(3).galinha(galinha).build(),
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA_2).quantidadeOvos(8).galinha(galinha).build(),
                Coleta.builder().idColeta(UUID.randomUUID()).dataColeta(COLETA_DATA_2).quantidadeOvos(4).galinha(galinha).build()
        );
    }



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
