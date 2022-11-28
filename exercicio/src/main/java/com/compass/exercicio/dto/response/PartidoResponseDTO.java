package com.compass.exercicio.dto.response;

import com.compass.exercicio.enums.IdeologiaEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PartidoResponseDTO {
    private Long id;
    private String nome;
    private String sigla;
    @Enumerated(EnumType.STRING)
    private IdeologiaEnum ideologia;

    private LocalDate dataFundacao;

    public PartidoResponseDTO(Long id, String nome, String sigla, IdeologiaEnum ideologiaEnum, LocalDate dataFundacao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.dataFundacao = dataFundacao;
    }

    public PartidoResponseDTO(Partido partido){
        this.id = partido.getId();
        this.nome = partido.getNome();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataFundacao = partido.getDataFundacao();
    }
    public PartidoResponseDTO(){
    }

    public static List<PartidoResponseDTO> converter(List<Partido> partidos){
        return partidos.stream().map(PartidoResponseDTO::new).collect(Collectors.toList());
    }
}
