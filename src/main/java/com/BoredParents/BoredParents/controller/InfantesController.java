package com.BoredParents.BoredParents.controller;


import com.BoredParents.BoredParents.Entities.Infantes;
import com.BoredParents.BoredParents.Service.InfanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Infantes")
public class InfantesController {

    @Autowired
    private InfanteService InfanteService;

    @PostMapping("/addInfantes")
    public Infantes saveOrUpdateInfante(@RequestBody Infantes i){
        return InfanteService.saveOrUpdateinfante(i);
    }

    @PutMapping("/updateInfantes")
    public Infantes updateInfante(@RequestBody Infantes i){
        return InfanteService.saveOrUpdateinfante(i);
    }

    @DeleteMapping("/{id}")
    public void deleteInfante(@PathVariable Long id){
        InfanteService.deleteinfante(id);
    }

}