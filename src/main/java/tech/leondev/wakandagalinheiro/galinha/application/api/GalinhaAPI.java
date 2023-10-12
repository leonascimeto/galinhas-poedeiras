package tech.leondev.wakandagalinheiro.galinha.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/galinhas")
public interface GalinhaAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    GalinhaResponseDTO salvarGalinha(@RequestBody @Valid GalinhaRequestDTO galinhaRequestDTO);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<GalinhaResponseDTO> listarGalinhas();

    @GetMapping("{idGalinha}")
    @ResponseStatus(HttpStatus.OK)
    GalinhaResponseDTO buscarGalinhaPeloId(@PathVariable UUID idGalinha);

    @PatchMapping("{idGalinha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alterarGalinha(@PathVariable UUID idGalinha, @RequestBody @Valid GalinhaRequestDTO galinhaRequestDTO);

    @DeleteMapping("{idGalinha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletarGalinha(@PathVariable UUID idGalinha);
}
