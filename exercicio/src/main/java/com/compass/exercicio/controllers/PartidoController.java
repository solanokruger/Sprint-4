package com.compass.exercicio.controllers;

import com.compass.exercicio.dto.request.PartidoRequestDTO;
import com.compass.exercicio.dto.response.AssociadoResponseDTO;
import com.compass.exercicio.dto.response.PartidoResponseDTO;
import com.compass.exercicio.enums.IdeologiaEnum;
import com.compass.exercicio.repositorio.PartidoRepositorio;
import com.compass.exercicio.service.PartidoService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoRepositorio partidoRepositorio;
    private final PartidoService partidoService;

    @PostMapping
    @Transactional
    public ResponseEntity<PartidoResponseDTO> cadastrarPartido(@RequestBody @Valid PartidoRequestDTO partidoRequestDTO){
        PartidoResponseDTO partidoResponseDTO = partidoService.criarPartido(partidoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoResponseDTO);
    }

    @GetMapping
    public List<PartidoResponseDTO> listarTodos(@RequestParam(required = false) IdeologiaEnum ideologia,
                                                Pageable pageable) {
        return partidoService.listarTodos(ideologia, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoResponseDTO> listarPeloId(@PathVariable Long id) {
        PartidoResponseDTO partidoResponseDTO = partidoService.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(partidoResponseDTO);
    }
    @GetMapping("/{id}/associados")
    public List<AssociadoResponseDTO> listarPeloPartido(@PathVariable Long id) {
        return partidoService.listarAssociadosDoPartido(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PartidoResponseDTO> atualizarPartido(
            @PathVariable Long id,
            @RequestBody @Valid PartidoRequestDTO partidoRequestDTO)
    {
        PartidoResponseDTO partidoResponseDTO =
                partidoService.atualizarPorId(id, partidoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(partidoResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PartidoResponseDTO> deletarPartido(@PathVariable Long id){
        partidoService.deletarPartido(id);
        return ResponseEntity.noContent().build();
    }

}
