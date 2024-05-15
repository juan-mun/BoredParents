package com.BoredParents.BoredParents.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.Recursos;
import com.BoredParents.BoredParents.Service.RecursosService;
import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursosController {
    
    @Autowired
    private RecursosService recursosService;

    @GetMapping("/getRecursos")
    public List<Recursos> getAllRecursos(){
        return recursosService.getAllRecursos();
    }

    @PostMapping("/saveRecurso")
    public Recursos saveRecurso(@RequestBody Recursos recurso){
        return recursosService.saveRecurso(recurso);
    }

}
