package com.BoredParents.BoredParents.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
