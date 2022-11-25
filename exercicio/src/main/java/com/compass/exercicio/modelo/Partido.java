package com.compass.exercicio.modelo;

import com.compass.exercicio.enums.IdeologiaEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PARTIDO")
public class Partido {

    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SIGLA")
    private String sigla;

    @Enumerated(EnumType.STRING)
    @Column(name = "IDEOLOGIA")
    private IdeologiaEnum ideologiaEnum;

    @Column(name = "DATA")
    private LocalDate dataFundacao;

    public Partido(String nome, String sigla, IdeologiaEnum ideologiaEnum, LocalDate dataFundacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.ideologiaEnum = ideologiaEnum;
        this.dataFundacao = dataFundacao;
    }

    public Partido() {
    }
}
