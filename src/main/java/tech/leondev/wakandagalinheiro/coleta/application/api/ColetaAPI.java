package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{idColeta}")
    @ResponseStatus(HttpStatus.OK)
    ColetaResponseDTO buscaColetaPeloId(@PathVariable UUID idColeta);

    @PatchMapping("{idColeta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alteraColeta(@RequestBody @Valid ColetaRequestDTO coletaRequestDTO, @PathVariable UUID idColeta);

    @DeleteMapping("{idColeta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaColeta(@PathVariable UUID idColeta);
}
