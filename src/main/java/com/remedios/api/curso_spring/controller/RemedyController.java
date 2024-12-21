package com.remedios.api.curso_spring.controller;

import com.remedios.api.curso_spring.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedio_api")
public class RemedyController {

    @Autowired
    RemedyRepository remedyRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DataAboutRemedy dataRemedy){
        remedyRepository.save(new Remedio(dataRemedy));
    }

    @GetMapping
    public ResponseEntity<List<DadosRemedioDTO>> listar(){
       var lista = remedyRepository
               .findAllByAtivoTrue()
               .stream()
               .map(DadosRemedioDTO::new)
               .toList();

       return ResponseEntity.ok(lista);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDTO atualizarDTO){
        var remedio = remedyRepository.getReferenceById(atualizarDTO.id());
        remedio.atualizarInfos(atualizarDTO);

        return ResponseEntity.ok(new DadosDetalhadosDeRemedio(remedio));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        remedyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = remedyRepository.getReferenceById(id);
        remedio.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        var remedio = remedyRepository.getReferenceById(id);
            remedio.reativar();
            return ResponseEntity.noContent().build();
    }

}
