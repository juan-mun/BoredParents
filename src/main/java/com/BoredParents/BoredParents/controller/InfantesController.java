package com.BoredParents.BoredParents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.Infantes;
import com.BoredParents.BoredParents.service.InfanteService;

@RestController
@RequestMapping("/Infantes")
public class InfantesController {
    
    @Autowired
    private InfanteService infanteService;

    @GetMapping("/getInfantes")
    public List<Infantes> getAllInfantes(){
        return infanteService.getInfantes();
    }

    @PostMapping("/saveInfantes")
    public Infantes savInfantes(@RequestBody Infantes infante){
        return infanteService.saveInfantes(infante);
    }

    @DeleteMapping("/{id}")
    public void deleteInfantes(@PathVariable Long id){
        infanteService.deleteInfante(id);
    }

}
