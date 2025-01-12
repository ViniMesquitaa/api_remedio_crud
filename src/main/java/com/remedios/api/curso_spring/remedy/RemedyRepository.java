package com.remedios.api.curso_spring.remedy;

import com.remedios.api.curso_spring.remedy.entities.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemedyRepository extends JpaRepository<Remedio, Long> {
    List<Remedio> findAllByAtivoTrue();
}
