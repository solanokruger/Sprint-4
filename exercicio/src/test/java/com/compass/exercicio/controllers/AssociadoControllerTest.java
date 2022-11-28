package com.compass.exercicio.controllers;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.compass.exercicio.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(controllers = AssociadoController.class)
@RequiredArgsConstructor
public class AssociadoControllerTest {

    public final String URl_API ="/associados";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssociadoService associadoService;

    @Test
    void deveriaListarTodos() throws Exception{
        AssociadoResponseDTO associadoResponseDTO = new AssociadoResponseDTO();
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get(URl_API)
                .accept(MediaType.APPLICATION_JSON)
                .content(criarRequest().toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MockHttpServletResponse response = resultado.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

    private AssociadoRequestDTO criarRequest() {
        AssociadoRequestDTO build = AssociadoRequestDTO.builder()
                .nome("Teste")
                .cargo(CargoEnum.NENHUM)
                .dataNascimento(LocalDate.of(2000, 10, 05))
                .sexoEnum(SexoEnum.FEMININO)
                .partido(null)
                .build();
        return build;
    }
}
