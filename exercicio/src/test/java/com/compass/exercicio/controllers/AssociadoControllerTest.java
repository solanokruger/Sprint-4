package com.compass.exercicio.controllers;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;

import java.time.LocalDate;

public class AssociadoControllerTest {

    final ThreadLocal<LocalDate> data = ThreadLocal.withInitial(() -> new LocalDate(2000, 10, 05))

    private AssociadoRequestDTO criarRequest() {
        return AssociadoRequestDTO.builder()
                .nome("Teste")
                .cargo(CargoEnum.NENHUM)
                .dataNascimento()
                .partido("PP")
                .sexoEnum(SexoEnum.FEMININO)
                .partido(1)
                .build();
    }
}
