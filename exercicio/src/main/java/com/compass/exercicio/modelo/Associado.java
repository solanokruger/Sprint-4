package com.compass.exercicio.modelo;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO_POLITICO")
    private CargoEnum cargo;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
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

    public Associado() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SexoEnum getSexoEnum() {
        return sexoEnum;
    }

    public void setSexoEnum(SexoEnum sexoEnum) {
        this.sexoEnum = sexoEnum;
    }

    @Nullable
    public Partido getPartido() {
        return partido;
    }

    public void setPartido(@Nullable Partido partido) {
        this.partido = partido;
    }
}
