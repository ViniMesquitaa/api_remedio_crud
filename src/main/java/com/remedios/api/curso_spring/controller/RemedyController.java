package com.remedios.api.curso_spring.controller;

import com.remedios.api.curso_spring.remedy.*;
import com.remedios.api.curso_spring.remedy.entities.Remedio;
import com.remedios.api.curso_spring.remedy.remedyDTO.DadosAtualizarDTO;
import com.remedios.api.curso_spring.remedy.remedyDTO.DadosDetalhadosDeRemedioDTO;
import com.remedios.api.curso_spring.remedy.remedyDTO.DadosRemedioDTO;
import com.remedios.api.curso_spring.remedy.remedyDTO.DataAboutRemedyDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedio_api")
public class RemedyController {

    @Autowired
    RemedyRepository remedyRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataAboutRemedyDTO dataRemedy, UriComponentsBuilder uriBuilder) {
        var remedio = new Remedio(dataRemedy);
        remedyRepository.save(remedio);
        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosDeRemedioDTO(remedio));
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

        return ResponseEntity.ok(new DadosDetalhadosDeRemedioDTO(remedio));

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
