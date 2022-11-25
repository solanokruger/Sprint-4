package com.compass.exercicio.modelo;

import com.compass.exercicio.enums.IdeologiaEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Date dataFundacao;

}
