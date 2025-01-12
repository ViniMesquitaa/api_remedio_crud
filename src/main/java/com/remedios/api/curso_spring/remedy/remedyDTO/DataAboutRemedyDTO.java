package com.remedios.api.curso_spring.remedy.remedyDTO;

import com.remedios.api.curso_spring.remedy.Laboratorio;
import com.remedios.api.curso_spring.remedy.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record DataAboutRemedyDTO(
        @NotBlank @NotNull
        String nome,

        @Enumerated
        Via via,

        @NotBlank
        String lote,

        @PositiveOrZero
        int quantidade,

        @Future
        LocalDate validade,

        @Enumerated
        Laboratorio laboratorio
        ) {
}
