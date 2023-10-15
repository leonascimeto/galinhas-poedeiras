package tech.leondev.wakandagalinheiro.coleta.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Tag(name = "Galinhas", description = "Recurso relacionado ao gerenciamento de galinhas poedeiras")
@RestController
@RequestMapping("v1/coletas")
public interface ColetaAPI {

    @Operation(
            summary = "Registra coleta",
            description = "Registra uma nova coleta de ovos de uma galinha poedeira."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ColetaResponseDTO salvarColeta(@RequestBody @Valid ColetaRequestDTO coletaRequestDTO);

    @Operation(
            summary = "Lista todas as  coletas",
            description = "Lista todos os registro de coleta de ovos."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ColetaResponseDTO> listaColetas();

    @Operation(
            summary = "Busca coleta por galinha",
            description = "Busca detalhes da coleta diária de uma galinha."
    )
    @GetMapping("galinhas/{idGalinha}/bydate/{data}")
    @ResponseStatus(HttpStatus.OK)
    ColetaDiariaGalinhaResponseDTO coletaDiariaPorGalinha(@PathVariable UUID idGalinha, @PathVariable LocalDate data);

    @Operation(
            summary = "Lista coletas por data",
            description = "Busca detalhes de coletas de uma data especifica."
    )
    @GetMapping("data/{data}")
    @ResponseStatus(HttpStatus.OK)
    ColetaDiariaResponseDTO listColetasPorData(@PathVariable LocalDate data);

    @Operation(
            summary = "Busca coleta pelo ID",
            description = "Busca detalhes de uma coleta pelo ID."
    )
    @GetMapping("{idColeta}")
    @ResponseStatus(HttpStatus.OK)
    ColetaResponseDTO buscaColetaPeloId(@PathVariable UUID idColeta);

    @Operation(
            summary = "Lista coletas por intervalo de tempo",
            description = "Lista detalhes de coletas dentro de um intervalo de datas."
    )
    @GetMapping("intervalo/inicio/{dataInicio}/fim/{dataFim}")
    @ResponseStatus(HttpStatus.OK)
    ColetaIntervalResponseDTO buscarColetaPorIntervalo(LocalDate dataInicio, LocalDate dataFim);

    @Operation(
            summary = "Altera coleta",
            description = "Altera dados de uma coleta pelo ID."
    )
    @PatchMapping("{idColeta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alteraColeta(@RequestBody @Valid ColetaAlteraRequestDTO coletaAlteraRequestDTO, @PathVariable UUID idColeta);

    @Operation(
            summary = "Deleta coleta",
            description = "Deleta registro de uma coleta pelo ID."
    )
    @DeleteMapping("{idColeta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaColeta(@PathVariable UUID idColeta);
}
