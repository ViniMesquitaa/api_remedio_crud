package com.remedios.api.curso_spring.remedy.remedyDTO;

import com.remedios.api.curso_spring.remedy.Laboratorio;
import com.remedios.api.curso_spring.remedy.entities.Remedio;
import com.remedios.api.curso_spring.remedy.Via;

import java.time.LocalDate;

public record DadosRemedioDTO(Long ID, String nome, Via via, String Lote, int quantidade, LocalDate validade, Laboratorio laboratorio) {
    public DadosRemedioDTO(Remedio remedio) {
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getQuantidade(), remedio.getValidade(), remedio.getLaboratorio());
    }
}
