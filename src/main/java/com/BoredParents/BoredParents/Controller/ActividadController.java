package com.BoredParents.BoredParents.Controller;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    // Endpoint para obtener la lista de actividades

    @GetMapping("/munoz")
    public List<Actividad> obtenerListaActividades() {
        return actividadService.obtenerListaActividades();
    }

    @GetMapping("/sanchez")
    public List<Actividad> ActividadesNoElectricas() {
        return actividadService.obtenerActividadesNoElectricas();
    }

    @GetMapping("/guevara")
    public List<Actividad> ActividadesBaratas() {
        return actividadService.obtenerActividadesBaratas();

    }

    @GetMapping("/Mendivelso")
    public List<Actividad> ActividadesRecreativas() {
        return actividadService.obtenerActividadesRecreActividades();
    }

}