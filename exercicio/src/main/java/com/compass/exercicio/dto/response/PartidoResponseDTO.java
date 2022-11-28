package com.compass.exercicio.dto.response;

import com.compass.exercicio.enums.IdeologiaEnum;
import com.compass.exercicio.modelo.Partido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class PartidoResponseDTO {
    private Long id;
    private String nome;
    private String sigla;
    private IdeologiaEnum ideologia;

    private LocalDate dataFundacao;

    public PartidoResponseDTO(Partido partido) {
        this.id = partido.getId();
        this.nome = partido.getNome();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataFundacao = partido.getDataFundacao();
    }

    public PartidoResponseDTO() {
    }

    public static List<PartidoResponseDTO> converter(List<Partido> partidos) {
        return partidos.stream().map(PartidoResponseDTO::new).collect(Collectors.toList());
    }
}
