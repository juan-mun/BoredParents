package com.BoredParents.BoredParents.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.lifeBook;
import com.BoredParents.BoredParents.Service.lifebookService;

@RestController
@RequestMapping("/lifebook")
public class lifebookController {
    
    @Autowired
    private lifebookService lifebookService;

    @PostMapping("/saveMaterial")
    public lifeBook saveMaterial(@RequestBody lifeBook material){
        return lifebookService.saveMaterial(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable Long id){
        lifebookService.deleteMaterial(id);
    }

}
