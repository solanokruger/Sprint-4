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

    @NotBlank
    private String nome;

    @NotBlank
    private String sigla;

    @Enumerated(EnumType.STRING)
    @NotNull
    private IdeologiaEnum ideologia;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFundacao;
}
