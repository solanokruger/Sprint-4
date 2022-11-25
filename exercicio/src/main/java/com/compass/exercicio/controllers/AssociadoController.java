package com.compass.exercicio.controllers;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.repositorio.AssociadoRepositorio;
import com.compass.exercicio.service.AssociadoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/associados")
@RequiredArgsConstructor
public class AssociadoController {

    private final AssociadoRepositorio associadoRepositorio;

   // private final AssociadoServiceImpl associadoServiceImpl;

//    @PostMapping
//    @Transactional
//    public ResponseEntity<AssociadoResponseDTO> cadastrarAssociadoSemPartido(@RequestBody @Valid AssociadoRequestDTO associadoRequestDTO){
//        AssociadoResponseDTO associadoResponseDTO = associadoServiceImpl.criar(associadoRequestDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(associadoResponseDTO);
//    }

    @GetMapping
    public List<AssociadoResponseDTO> listarTodos() {
        List<Associado> associados = associadoRepositorio.findAll();
        return AssociadoResponseDTO.converter(associados);
    }

}
