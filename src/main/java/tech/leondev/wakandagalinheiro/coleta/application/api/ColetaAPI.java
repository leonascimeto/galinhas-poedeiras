package tech.leondev.wakandagalinheiro.coleta.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/coletas")
public interface ColetaAPI {

    @PostMapping
    ColetaResponseDTO salvarColeta(@RequestBody @Valid ColetaRequestDTO coletaRequestDTO);
}
