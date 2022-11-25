package com.compass.exercicio.repositorio;

import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepositorio extends JpaRepository<Partido, Long> {

}
