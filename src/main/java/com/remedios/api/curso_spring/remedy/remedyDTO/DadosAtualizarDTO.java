package com.remedios.api.curso_spring.remedy.remedyDTO;

import com.remedios.api.curso_spring.remedy.Via;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizarDTO(
                                @NotNull
                                Long id,
                                String nome,
                                Via via,
                                String lote) {

}
