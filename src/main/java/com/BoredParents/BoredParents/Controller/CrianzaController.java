package com.BoredParents.BoredParents.Controller;

import com.BoredParents.BoredParents.Entities.Crianza;
import com.BoredParents.BoredParents.Service.CrianzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recursos")  // Define la base URL para todas las operaciones de este controlador
public class CrianzaController {

    private final CrianzaService crianzaService;

    @Autowired
    public CrianzaController(CrianzaService crianzaService) {
        this.crianzaService = crianzaService;
    }

    // Endpoint para obtener todos los recursos
    @GetMapping
    public List<Crianza> getAllResources() {
        return crianzaService.getAllResources();
    }
}