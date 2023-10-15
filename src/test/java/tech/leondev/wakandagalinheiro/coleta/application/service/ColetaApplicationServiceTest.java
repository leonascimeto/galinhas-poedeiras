package tech.leondev.wakandagalinheiro.coleta.application.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.leondev.wakandagalinheiro.DataHelper;
import tech.leondev.wakandagalinheiro.coleta.application.api.*;
import tech.leondev.wakandagalinheiro.coleta.application.repository.ColetaRepository;
import tech.leondev.wakandagalinheiro.coleta.domain.Coleta;
import tech.leondev.wakandagalinheiro.galinha.application.repository.GalinhaRepository;
import tech.leondev.wakandagalinheiro.galinha.domain.Galinha;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ColetaApplicationServiceTest {

    @InjectMocks
    ColetaApplicationService coletaApplicationService;

    @Mock
    ColetaRepository coletaRepository;

    @Mock
    GalinhaRepository galinhaRepository;

    Coleta coletaMock = DataHelper.gerarColeta();
    ColetaRequestDTO coletaRequestMock = DataHelper.requestSalvaColeta(coletaMock);
    Galinha galinhaMock = DataHelper.gerarGalinha();

    @Test
    void deveSalvarColetaComSucesso() {
        when(galinhaRepository.buscarGalinhaPeloId(any(UUID.class))).thenReturn(galinhaMock);
        when(coletaRepository.salvarColeta(any())).thenReturn(coletaMock);
        ColetaResponseDTO response = coletaApplicationService.salvaColeta(coletaRequestMock);
        assertEquals("9671fc6a-5b56-41d6-8bde-61fe09d25f81", response.getIdColeta().toString());
        assertEquals(LocalDate.of(2023, 10, 14), response.getDataColeta());
        assertEquals("aa2d3178-ea30-4726-82fb-3be22f0da36d", response.getIdGalinha().toString());
        assertEquals(4, response.getQuantidadeOvos());
    }

    @Test
    void deveLstarTodasColetasComSucesso(){
        when(coletaRepository.listaColetas()).thenReturn(DataHelper.gerarListaColetaParaMedia());
        List<ColetaResponseDTO> response = coletaApplicationService.listaColetas();
        verify(coletaRepository, times(1)).listaColetas();
        assertEquals(5, response.size());
    }

    @Test
    void deveBuscarColetaPeloIdComSucesso(){
        when(coletaRepository.buscaColetaPeloId(any())).thenReturn(coletaMock);
        ColetaResponseDTO response = coletaApplicationService.buscaColetaPeloId(any());
        verify(coletaRepository, times(1)).buscaColetaPeloId(any());
        assertEquals("9671fc6a-5b56-41d6-8bde-61fe09d25f81", response.getIdColeta().toString());
        assertEquals(LocalDate.of(2023, 10, 14), response.getDataColeta());
        assertEquals("aa2d3178-ea30-4726-82fb-3be22f0da36d", response.getIdGalinha().toString());
        assertEquals(4, response.getQuantidadeOvos());
    }

    @Test
    void deveAlterarColetaComSucesso(){
        when(coletaRepository.buscaColetaPeloId(coletaMock.getIdColeta())).thenReturn(coletaMock);
        when(galinhaRepository.buscarGalinhaPeloId(coletaMock.getGalinha().getIdGalinha())).thenReturn(galinhaMock);
        coletaApplicationService.alteraColeta(DataHelper.requestAlteraColeta(), coletaMock.getIdColeta());
        assertEquals(100, coletaMock.getQuantidadeOvos());
        assertEquals("aa2d3178-ea30-4726-82fb-3be22f0da36d", coletaMock.getGalinha().getIdGalinha().toString());
        assertEquals(LocalDate.of(2023, 9, 14), coletaMock.getDataColeta());
    }

    @Test
    void deveDeletarColetaComSucesso(){
        when(coletaRepository.buscaColetaPeloId(coletaMock.getIdColeta())).thenReturn(coletaMock);
        coletaApplicationService.deletaColeta(coletaMock.getIdColeta());
        verify(coletaRepository, times(1)).deletaColeta(coletaMock);
    }

    @Test
    void deveListaColetaDiariaPorGalinha(){
        when(galinhaRepository.buscarGalinhaPeloId(galinhaMock.getIdGalinha())).thenReturn(galinhaMock);
        when(coletaRepository.findColetasPorGalinhaData(galinhaMock, DataHelper.COLETA_DATA)).thenReturn(DataHelper.gerarListaColeta());
        ColetaDiariaGalinhaResponseDTO response = coletaApplicationService.coletaDiariaPorGalinha(galinhaMock.getIdGalinha(),
                DataHelper.COLETA_DATA);
        assertEquals(3, response.getColetas().size());
        assertEquals("aa2d3178-ea30-4726-82fb-3be22f0da36d", response.getIdGalinha().toString());
        assertEquals("penelope", response.getNameGalinha());
        assertEquals(6, response.getTotalOvos());
    }

    @Test
    void develistarColetasDiaria(){
        when(coletaRepository.findColetasPorData(DataHelper.COLETA_DATA)).thenReturn(DataHelper.gerarListaColeta());
        ColetaDiariaResponseDTO response = coletaApplicationService.listColetasDiaria(DataHelper.COLETA_DATA);
        assertEquals(3, response.getColetas().size());
        assertEquals(LocalDate.of(2023, 10, 14), response.getData());
        assertEquals(6, response.getTotalOvos());
    }

    @Test
    void deveListarColetasPorIntervaloDetempo(){
        when(coletaRepository.findColetasPorIntervalo(DataHelper.COLETA_DATA, DataHelper.COLETA_DATA_2))
                .thenReturn(DataHelper.gerarListaColetaParaMedia());
        ColetaIntervalResponseDTO response = coletaApplicationService
                .listaColetaPorIntervalo(DataHelper.COLETA_DATA, DataHelper.COLETA_DATA_2);
        assertEquals(5, response.getColetas().size());
        assertEquals(18, response.getTotalOvos());
        assertEquals(9.0, response.getMediaOvosPorDia());
    }

    @Test
    void deveCalcularTotalOvos(){
        int totalOvos = coletaApplicationService.calcularTotalOvos(DataHelper.gerarListaColeta());
        assertEquals(6, totalOvos);
    }

    @Test
    void deveCalcularMediaDiariaOvos(){
        double media = coletaApplicationService.calcularMediaDiariaOvos(13,
                DataHelper.COLETA_DATA,
                DataHelper.COLETA_DATA_2);
        assertEquals(6.5, media);
    }
}