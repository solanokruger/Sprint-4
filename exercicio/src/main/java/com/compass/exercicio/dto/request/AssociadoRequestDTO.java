package com.compass.exercicio.dto.request;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoRequestDTO {

    private String nome;
    private CargoEnum cargo;
    private LocalDate dataNascimento;
    private SexoEnum sexoEnum;
    private Partido partido;

    public Associado converter(AssociadoRequestDTO associadoRequestDTO) {
        return new Associado(
                nome = associadoRequestDTO.nome,
                cargo = associadoRequestDTO.cargo,
                dataNascimento = associadoRequestDTO.dataNascimento,
                sexoEnum = associadoRequestDTO.sexoEnum,
                partido = associadoRequestDTO.partido);
    }
}
