package tech.leondev.wakandagalinheiro.galinha.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/galinhas")
public interface GalinhaAPI {
    @PostMapping
    GalinhaResponseDTO salvarGalinha(@RequestBody @Valid GalinhaRequestDTO galinhaRequestDTO);

    @GetMapping
    List<GalinhaResponseDTO> listarGalinhas();

    @GetMapping("{idGalinha}")
    GalinhaResponseDTO buscarGalinhaPeloId(@PathVariable UUID idGalinha);
}
