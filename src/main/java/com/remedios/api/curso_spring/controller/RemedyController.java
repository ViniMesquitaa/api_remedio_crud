package com.remedios.api.curso_spring.controller;

import com.remedios.api.curso_spring.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DadosRemedioDTO> listar(){
       return remedyRepository.findAll().stream().map(DadosRemedioDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarDTO atualizarDTO){
        var remedio = remedyRepository.getReferenceById(atualizarDTO.id());
        remedio.atualizarInfos(atualizarDTO);

    }
}
