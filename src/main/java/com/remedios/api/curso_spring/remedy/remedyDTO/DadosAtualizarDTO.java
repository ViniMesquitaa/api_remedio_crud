package com.remedios.api.curso_spring.remedio;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;


public record DadosAtualizarDTO(
                                @NotNull
                                Long id,
                                String nome,
                                Via via,
                                String lote) {

}
