package com.compass.exercicio.service;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.repositorio.AssociadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssociadoServiceImpl {

    private final AssociadoRepositorio associadoRepositorio;

    private final ModelMapper modelMapper;

    public AssociadoResponseDTO criar(AssociadoRequestDTO associadoRequestDTO){
        Associado associado = modelMapper.map(associadoRequestDTO, Associado.class);
        Associado associadoCriado = associadoRepositorio.save(associado);
        return modelMapper.map(associadoCriado, AssociadoResponseDTO.class);
    }

    public List<Associado> listar() {
       return associadoRepositorio.findAll();
    }


}
