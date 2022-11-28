package com.compass.exercicio.modelo;

import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import lombok.*;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSOCIADO")
public class Associado {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Enumerated(EnumType.STRING)
 //   @Convert(converter = Converter.class)
    @Column(name = "CARGO_POLITICO")
    private CargoEnum cargo;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
//    @Convert(converter = Converter.class)
    @Column(name = "SEXO")
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

}
