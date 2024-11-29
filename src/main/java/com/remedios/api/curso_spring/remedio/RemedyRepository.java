package com.remedios.api.curso_spring.remedio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedyRepository extends JpaRepository<Remedio, Long> {
}
