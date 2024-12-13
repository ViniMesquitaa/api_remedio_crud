package com.remedios.api.curso_spring.remedio;

import java.time.LocalDate;

public record DadosRemedioDTO(Long ID, String nome, Via via, String Lote, int quantidade, LocalDate validade, Laboratorio laboratorio) {
    public DadosRemedioDTO(Remedio remedio) {
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getQuantidade(), remedio.getValidade(), remedio.getLaboratorio());
    }
}
