package com.remedios.api.curso_spring.controller;

import com.remedios.api.curso_spring.remedio.DataAboutRemedy;
import com.remedios.api.curso_spring.remedio.Remedio;
import com.remedios.api.curso_spring.remedio.RemedyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remedios")
public class RemedyController {
    @Autowired
    RemedyRepository remedyRepository;

    @PostMapping
    public void cadastrar(@RequestBody DataAboutRemedy dataRemedy){
        remedyRepository.save(new Remedio(dataRemedy));
    }
}
