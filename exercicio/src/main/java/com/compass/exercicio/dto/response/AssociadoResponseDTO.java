package com.compass.exercicio.dto.response;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoResponseDTO {

    private Long id;
    private String nome;
    private CargoEnum cargo;
    private LocalDate dataNascimento;
    private SexoEnum sexoEnum;
    private Partido partido;


    public AssociadoResponseDTO(Associado associado) {
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargo = associado.getCargo();
        this.dataNascimento = associado.getDataNascimento();
        this.sexoEnum = associado.getSexoEnum();
        this.partido = associado.getPartido();
    }

    public static List<AssociadoResponseDTO> converter(List<Associado> associados) {
        return associados.stream().map(AssociadoResponseDTO::new).collect(Collectors.toList());
    }


}
