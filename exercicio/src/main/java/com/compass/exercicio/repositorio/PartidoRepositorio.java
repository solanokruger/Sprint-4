package com.compass.exercicio.repositorio;

import com.compass.exercicio.enums.IdeologiaEnum;
import com.compass.exercicio.modelo.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface PartidoRepositorio extends JpaRepository<Partido, Long> {

    Page<Partido> findAllByIdeologia(IdeologiaEnum ideologia, Pageable pageable);
}
