package com.BoredParents.BoredParents.controller;

<<<<<<< HEAD

import com.BoredParents.BoredParents.Entities.Infantes;
import com.BoredParents.BoredParents.Service.InfanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
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
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece

@RestController
@RequestMapping("/Infantes")
public class InfantesController {
<<<<<<< HEAD

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
=======
    
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
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece
