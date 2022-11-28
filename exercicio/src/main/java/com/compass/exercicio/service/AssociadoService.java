package com.compass.exercicio.service;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.dto.response.PartidoResponseDTO;
import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.enums.IdeologiaEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import com.compass.exercicio.repositorio.AssociadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepositorio associadoRepositorio;
    private final ModelMapper modelMapper;

    public AssociadoResponseDTO criar(AssociadoRequestDTO associadoRequestDTO){

        Associado associado = associadoRequestDTO.converter(associadoRequestDTO);
        Associado associadoCriado = associadoRepositorio.save(associado);
        return modelMapper.map(associadoCriado, AssociadoResponseDTO.class);
    }

    public List<AssociadoResponseDTO> listarTodos(CargoEnum cargo, Pageable pageable) {
        Page<Associado> page = cargo == null ?
                associadoRepositorio.findAll(pageable) :
                associadoRepositorio.findAllByCargo(cargo, pageable);

        return AssociadoResponseDTO.converter(page.toList());
    }

    public AssociadoResponseDTO listarPorId(Long id){
        Optional<Associado> associado = associadoRepositorio.findById(id);
        return modelMapper.map(associado, AssociadoResponseDTO.class);
    }

    public AssociadoResponseDTO atualizarPorId(Long id, AssociadoRequestDTO associadoRequestDTO) {
        Associado associadoNovo = modelMapper.map(associadoRequestDTO, Associado.class);
        associadoNovo.setId(id);
        Associado associadoAtualizado = associadoRepositorio.save(associadoNovo);

        return modelMapper.map(associadoAtualizado, AssociadoResponseDTO.class);
    }

    public void deletarAssociado(Long id) {
        associadoRepositorio.deleteById(id);
    }

    public void deletarAssociadoDoPartido(Long id, Long idPartido) {
        Associado associado = associadoRepositorio.findById(id).orElseThrow(NullPointerException::new);
        if (associado.getPartido().getId() == idPartido){
            associado.setPartido(null);
            associadoRepositorio.save(associado);
        }else {
            throw new RuntimeException();
        }
    }
}
