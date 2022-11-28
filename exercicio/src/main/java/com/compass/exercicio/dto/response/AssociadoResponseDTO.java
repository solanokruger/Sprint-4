package com.compass.exercicio.dto.response;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AssociadoResponseDTO {

    private Long id;
    private String nome;
    private CargoEnum cargo;
    private LocalDate dataNascimento;

    private SexoEnum sexoEnum;
    private Partido partido;

    public AssociadoResponseDTO(Long id, String nome, CargoEnum cargo, LocalDate dataNascimento, SexoEnum sexoEnum, Partido partido) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.sexoEnum = sexoEnum;
        this.partido = partido;
    }

    public AssociadoResponseDTO(Associado associado){
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargo = associado.getCargo();
        this.dataNascimento = associado.getDataNascimento();
        this.sexoEnum = associado.getSexoEnum();
        this.partido = associado.getPartido();
    }

    public AssociadoResponseDTO(){
    }

    public static List<AssociadoResponseDTO> converter(List<Associado> associados){
        return associados.stream().map(AssociadoResponseDTO::new).collect(Collectors.toList());
    }



}
