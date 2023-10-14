package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/coletas")
public interface ColetaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ColetaResponseDTO salvarColeta(@RequestBody @Valid ColetaRequestDTO coletaRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ColetaResponseDTO> listaColetas();

    @GetMapping("galinhas/{idGalinha}/byDate/{data}")
    @ResponseStatus(HttpStatus.OK)
    ColetaDiariaGalinhaResponseDTO coletaDiariaPorGalinha(@PathVariable UUID idGalinha, @PathVariable LocalDate data);

    @GetMapping("byDate/{data}")
    @ResponseStatus(HttpStatus.OK)
    ColetaDiariaResponseDTO listColetasPorData(@PathVariable LocalDate data);

    @GetMapping("{idColeta}")
    @ResponseStatus(HttpStatus.OK)
    ColetaResponseDTO buscaColetaPeloId(@PathVariable UUID idColeta);

    @PatchMapping("{idColeta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alteraColeta(@RequestBody @Valid ColetaAlteraRequestDTO coletaAlteraRequestDTO, @PathVariable UUID idColeta);

    @DeleteMapping("{idColeta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaColeta(@PathVariable UUID idColeta);
}
