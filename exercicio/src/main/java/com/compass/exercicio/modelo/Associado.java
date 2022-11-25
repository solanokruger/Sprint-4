package com.compass.exercicio.modelo;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ASSOCIADO")
public class Associado {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CARGO_POLITICO")
    private CargoEnum cargo;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private SexoEnum sexoEnum;

    @ManyToOne
    @Nullable
    private Partido partido;


}
