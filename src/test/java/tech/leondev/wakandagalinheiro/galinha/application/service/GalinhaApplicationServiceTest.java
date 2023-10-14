package tech.leondev.wakandagalinheiro.galinha.application.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.leondev.wakandagalinheiro.DataHelper;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaRequestDTO;
import tech.leondev.wakandagalinheiro.galinha.application.api.GalinhaResponseDTO;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;
import tech.leondev.wakandagalinheiro.handler.ApiException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class GalinhaApplicationServiceTest {

    @InjectMocks
    GalinhaApplicationService galinhaApplicationService;

    @Mock
    GalinhaRepository galinhaRepository;

    Galinha galinhaMock = DataHelper.gerarGalinha();
    List<Galinha> listaGalinhas = DataHelper.gerarListaGalinhas();
    GalinhaRequestDTO requestSalvaGalinha = DataHelper.requestSalvaGalinha(galinhaMock);
    GalinhaRequestDTO requestAlterGalinha = DataHelper.requestAlteraGalinha();

    @Test
    void deveCadastrarGalinhaComSucesso() {
        when(galinhaRepository.salvarGalinha(any())).thenReturn(galinhaMock);
        GalinhaResponseDTO response = galinhaApplicationService.salvarGalinha(requestSalvaGalinha);
        verify(galinhaRepository, times(1)).salvarGalinha(any());
        assertEquals("penelope", response.getName());
        assertEquals(LocalDateTime.of(2023, 1, 15, 6, 30), response.getDataNascimento());
        assertEquals("aa2d3178-ea30-4726-82fb-3be22f0da36d", response.getIdGalinha().toString());
    }

    @Test
    void deveListarGalinhasComSucesso(){
        when(galinhaRepository.listarGalinhas()).thenReturn(listaGalinhas);
        List<GalinhaResponseDTO> reponse = galinhaApplicationService.listarGalinhas();
        verify(galinhaRepository, times(1)).listarGalinhas();
        assertEquals(10, reponse.size());
    }

    @Test
    void deveBuscarGalinhaPeloIdCOmSucesso(){
        when(galinhaRepository.buscarGalinhaPeloId(galinhaMock.getIdGalinha())).thenReturn(galinhaMock);
        GalinhaResponseDTO response = galinhaApplicationService.buscarGalinhaPeloId(galinhaMock.getIdGalinha());
        verify(galinhaRepository, times(1)).buscarGalinhaPeloId(galinhaMock.getIdGalinha());
        assertEquals("penelope", response.getName());
        assertEquals(LocalDateTime.of(2023, 1, 15, 6, 30), response.getDataNascimento());
        assertEquals("aa2d3178-ea30-4726-82fb-3be22f0da36d", response.getIdGalinha().toString());
    }

    @Test
    void deveAlterarGalinhaComSucesso(){
        when(galinhaRepository.buscarGalinhaPeloId(any(UUID.class))).thenReturn(galinhaMock);
        galinhaApplicationService.alterarGalinha(galinhaMock.getIdGalinha(), requestAlterGalinha);
        verify(galinhaRepository, times(1)).salvarGalinha(any());
        assertEquals("julia", galinhaMock.getName());
        assertEquals(LocalDateTime.of(2023, 1, 12, 6, 30), galinhaMock.getDataNascimento());
    }

    @Test
    void deveDeletarGalinhaComSucesso(){
        when(galinhaRepository.buscarGalinhaPeloId(galinhaMock.getIdGalinha())).thenReturn(galinhaMock);
        galinhaApplicationService.deletaGalinha(galinhaMock.getIdGalinha());
        verify(galinhaRepository, times(1)).deletaGalinha(galinhaMock);
    }
}