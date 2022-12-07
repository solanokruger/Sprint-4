package com.compass.exercicio.modelo;

import com.compass.exercicio.enums.IdeologiaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity(name = "Partido")
@Table(name = "partido")
@NoArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sigla;

    @Enumerated(EnumType.STRING)
    private IdeologiaEnum ideologia;

    @Column(nullable = false, name = "data_fundacao")
    private LocalDate dataFundacao;

    public Partido(String nome, String sigla, IdeologiaEnum ideologia, LocalDate dataFundacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.dataFundacao = dataFundacao;
    }

}
