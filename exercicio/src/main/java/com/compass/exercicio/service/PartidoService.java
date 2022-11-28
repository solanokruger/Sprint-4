package com.compass.exercicio.service;

import com.compass.exercicio.dto.request.PartidoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.dto.response.PartidoResponseDTO;
import com.compass.exercicio.enums.IdeologiaEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import com.compass.exercicio.repositorio.AssociadoRepositorio;
import com.compass.exercicio.repositorio.PartidoRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidoService {

    private final AssociadoRepositorio associadoRepositorio;
    private final PartidoRepositorio partidoRepositorio;
    private final ModelMapper modelMapper;

    public PartidoResponseDTO criarPartido(PartidoRequestDTO partidoRequestDTO){
        Partido partido = modelMapper.map(partidoRequestDTO, Partido.class);
        Partido partidoCriado = partidoRepositorio.save(partido);
        return modelMapper.map(partidoCriado, PartidoResponseDTO.class);
    }

    public List<PartidoResponseDTO> listarTodos(IdeologiaEnum ideologia, Pageable pageable) {
        Page<Partido> page = ideologia == null ?
                partidoRepositorio.findAll(pageable) :
                partidoRepositorio.findAllByIdeologia(ideologia, pageable);

        return PartidoResponseDTO.converter(page.toList());
    }

    public PartidoResponseDTO listarPorId(Long id){
        Optional<Partido> partidos = partidoRepositorio.findById(id);
        return modelMapper.map(partidos, PartidoResponseDTO.class);
    }

    public List<AssociadoResponseDTO> listarAssociadosDoPartido(Long id) {
        List<Associado> associados = associadoRepositorio.findAllByPartido(id);
        return AssociadoResponseDTO.converter(associados);
    }

    public PartidoResponseDTO atualizarPorId(Long id, PartidoRequestDTO partidoRequestDTO) {
            Partido partidoNovo = modelMapper.map(partidoRequestDTO, Partido.class);
            partidoNovo.setId(id);
            Partido partidoAtualizado = partidoRepositorio.save(partidoNovo);

            return modelMapper.map(partidoAtualizado, PartidoResponseDTO.class);
    }

    public void deletarPartido(Long id) {
        partidoRepositorio.deleteById(id);
    }
}
