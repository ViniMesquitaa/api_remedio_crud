package com.remedios.api.curso_spring.remedio;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "Remedios-DataBase")
@Entity(name = "data_remedios")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Remedio {

     public Remedio(DataAboutRemedy data) {
         this.nome = data.nome();
         this.via = data.via();
         this.lote = data.lote();
         this.quantidade = data.quantidade();
         this.validade = data.validade();
         this.laboratorio = data.laboratorio();
         this.ativo = true;
     }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;
    
    private String lote ;
    private int quantidade;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private boolean ativo;

    public boolean getAtivo() {
        return this.ativo = ativo;
    }

    public void atualizarInfos(@Valid DadosAtualizarDTO dadosAtualizarDTO){
        if(dadosAtualizarDTO.nome() != null){
            this.nome = dadosAtualizarDTO.nome();
        } if(dadosAtualizarDTO.via() != null){
            this.via = dadosAtualizarDTO.via();
        } if(dadosAtualizarDTO.lote() != null){
            this.lote = dadosAtualizarDTO.lote();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}
