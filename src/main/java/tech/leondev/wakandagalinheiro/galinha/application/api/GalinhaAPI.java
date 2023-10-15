package tech.leondev.wakandagalinheiro.galinha.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Galinhas", description = "Recurso relacionado ao gerenciamento de galinhas poedeiras")
@RestController
@RequestMapping("v1/galinhas")
public interface GalinhaAPI {

    @Operation(
            summary = "Registra galinha",
            description = "Registra uma nova galinha poedeira."
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    GalinhaResponseDTO salvarGalinha(@RequestBody @Valid GalinhaRequestDTO galinhaRequestDTO);

    @Operation(
            summary = "Lista galinhas",
            description = "Lista todas as galinha poedeira."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<GalinhaResponseDTO> listarGalinhas();

    @Operation(
            summary = "Busca galinha",
            description = "Busca detalhes de uma galinha poedeira pelo ID."
    )
    @GetMapping("{idGalinha}")
    @ResponseStatus(HttpStatus.OK)
    GalinhaResponseDTO buscarGalinhaPeloId(@PathVariable UUID idGalinha);

    @Operation(
            summary = "Altera galinha",
            description = "Altera dados de uma galinha poedeira pelo ID."
    )
    @PatchMapping("{idGalinha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alterarGalinha(@PathVariable UUID idGalinha, @RequestBody @Valid GalinhaRequestDTO galinhaRequestDTO);

    @Operation(
            summary = "Deleta galinha",
            description = "Deleta uma galinha poedeira pelo ID"
    )
    @DeleteMapping("{idGalinha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletarGalinha(@PathVariable UUID idGalinha);
}
