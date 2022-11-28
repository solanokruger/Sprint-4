package com.compass.exercicio.modelo;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Associado")
@Table(name = "associado")
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    //   @Convert(converter = Converter.class)
    private CargoEnum cargo;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
//    @Convert(converter = Converter.class)
    private SexoEnum sexoEnum;

    @ManyToOne
    @Nullable
    private Partido partido;

    public Associado(String nome, CargoEnum cargo, LocalDate dataNascimento, SexoEnum sexoEnum, @Nullable Partido partido) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.sexoEnum = sexoEnum;
        this.partido = partido;
    }

    public Associado converter(AssociadoRequestDTO associadoRequestDTO){
        return new Associado(nome, cargo, dataNascimento, sexoEnum, partido);
    }


}
