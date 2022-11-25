package com.compass.exercicio.dto.request;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.compass.exercicio.modelo.Partido;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoRequestDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexoEnum;

    @Nullable
    private Partido partido;

}
