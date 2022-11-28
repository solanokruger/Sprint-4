package com.compass.exercicio.dto.request;

import com.compass.exercicio.enums.IdeologiaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidoRequestDTO {

    private String nome;
    private String sigla;
    private IdeologiaEnum ideologia;
    private LocalDate dataFundacao;
}
