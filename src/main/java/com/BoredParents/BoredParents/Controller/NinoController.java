package com.BoredParents.BoredParents.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.Nino;
import com.BoredParents.BoredParents.Service.NinoService;

@RestController
@RequestMapping("/ninos")
public class NinoController {
    
    @Autowired
    private NinoService ninoService;

    @GetMapping("/getNinos")
    public List<Nino> getAllNinos(){
        return ninoService.getAllNinos();
    }

    @PostMapping("/saveNino")
    public Nino saveNino(@RequestBody Nino nino){
        return ninoService.saveNino(nino);
    }

    @PutMapping("/updateNino")
    public Nino updateNino(@RequestBody Nino nino){
        return ninoService.saveNino(nino);
    }

    @DeleteMapping("/{id}")
    public void deleteNino(@PathVariable Long id){
        ninoService.deleteNino(id);
    }

}
