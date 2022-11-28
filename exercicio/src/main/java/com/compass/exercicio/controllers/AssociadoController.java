package com.compass.exercicio.controllers;

import com.compass.exercicio.dto.request.AssociadoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.repositorio.AssociadoRepositorio;
import com.compass.exercicio.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    private final AssociadoService associadoService;

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoResponseDTO> cadastrarAssociadoSemPartido(@RequestBody @Valid AssociadoRequestDTO associadoRequestDTO){
        AssociadoResponseDTO associadoResponseDTO = associadoService.criar(associadoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AssociadoResponseDTO>> listarTodos(@RequestParam(required = false) CargoEnum cargo,
                                                                  Pageable pageable){
        List<AssociadoResponseDTO> associadoResponseDTO = associadoService.listarTodos(cargo, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(associadoResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoResponseDTO> listarPeloId(@PathVariable Long id) {
        AssociadoResponseDTO associadoResponseDTO = associadoService.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(associadoResponseDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociadoResponseDTO> atualizarAssociado(
            @PathVariable Long id,
            @RequestBody @Valid AssociadoRequestDTO associadoRequestDTO)
    {
        AssociadoResponseDTO associadoResponseDTO =
                associadoService.atualizarPorId(id, associadoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(associadoResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociadoResponseDTO> deletarAssociado(@PathVariable Long id){
        associadoService.deletarAssociado(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/partidos/{idPartido}")
    @Transactional
    public ResponseEntity<AssociadoResponseDTO> deletarAssociadoDoPartido(@PathVariable Long id, @PathVariable Long idPartido){
        associadoService.deletarAssociadoDoPartido(id, idPartido);
        return ResponseEntity.noContent().build();
    }

}
