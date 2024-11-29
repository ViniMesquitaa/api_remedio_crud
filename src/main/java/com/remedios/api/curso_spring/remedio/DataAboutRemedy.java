package com.remedios.api.curso_spring.remedio;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataAboutRemedy(
        @NotBlank @NotNull
        String nome,

        @Enumerated
        Via via,
        @NotBlank
        String lote,

        int quantidade,

        @Future
        LocalDate validade,

        @Enumerated
        Laboratorio laboratorio
        ) {
}
