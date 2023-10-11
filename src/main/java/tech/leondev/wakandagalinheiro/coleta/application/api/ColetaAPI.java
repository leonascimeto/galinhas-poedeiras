package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/coletas")
public interface ColetaAPI {

    @PostMapping
    ColetaResponseDTO salvarColeta(@RequestBody @Valid ColetaRequestDTO coletaRequestDTO);

    @GetMapping
    List<ColetaResponseDTO> listaColetas();

    @GetMapping("{idColeta}")
    ColetaResponseDTO buscaColetaPeloId(@PathVariable UUID idColeta);

    @PatchMapping("{idColeta}")
    void alteraColeta(@RequestBody @Valid ColetaRequestDTO coletaRequestDTO, @PathVariable UUID idColeta);
}
