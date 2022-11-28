package com.compass.exercicio.repositorio;

import com.compass.exercicio.enums.CargoEnum;
import com.compass.exercicio.modelo.Associado;
import com.compass.exercicio.modelo.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociadoRepositorio extends JpaRepository<Associado, Long> {

    List<Associado> findAllByPartido(Long id);

    Page<Associado> findAllByCargo(CargoEnum cargo, Pageable pageable);
}
