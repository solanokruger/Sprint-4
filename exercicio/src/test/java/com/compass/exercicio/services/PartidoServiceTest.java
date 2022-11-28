package com.compass.exercicio.services;

import com.compass.exercicio.dto.request.PartidoRequestDTO;
import com.compass.exercicio.dto.response.PartidoResponseDTO;
import com.compass.exercicio.modelo.Partido;
import com.compass.exercicio.repositorio.PartidoRepositorio;
import com.compass.exercicio.service.PartidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
public class PartidoServiceTest {

    @Mock
    PartidoRepositorio partidoRepositorio;

    @Mock
    PartidoService partidoService;

    @InjectMocks
    private ModelMapper modelMapper;

    @Test
    void deveriaCriarUmPartido(){
        modelMapper = mock(ModelMapper.class);
        var partido = new Partido();
        var partidoRequestDTO = new PartidoRequestDTO();
        var partidoResponseDTO = new PartidoResponseDTO();

        Mockito.when(modelMapper.map(ArgumentMatchers.any(), eq(Partido.class))).thenReturn(partido);
        Mockito.when(partidoRepositorio.save(any())).thenReturn(partido);
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), eq(PartidoResponseDTO.class))).thenReturn(partidoResponseDTO);

        PartidoResponseDTO partidoResponseDTO1 = partidoService.criarPartido(partidoRequestDTO);
        assertEquals(partidoResponseDTO, partidoResponseDTO1);
        Mockito.verify(partidoRepositorio).save(ArgumentMatchers.any());

    }
}
