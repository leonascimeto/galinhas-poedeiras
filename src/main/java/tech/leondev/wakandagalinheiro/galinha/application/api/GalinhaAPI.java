package tech.leondev.wakandagalinheiro.galinha.application.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/galinhas")
public interface GalinhaAPI {
    @PostMapping
    GalinhaResponseDTO salvarGalinha(@RequestBody @Valid GalinhaRequestDTO galinhaRequestDTO);
}
