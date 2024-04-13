package com.BoredParents.BoredParents.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.Service.ActividadService;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    
    @Autowired
    private ActividadService actividadService;

    @RequestMapping("/getActivity")
    public List<Actividad> getAllActividades (){
        return actividadService.getAllActividades();
    }

    @RequestMapping("/addActivity")
    public Actividad saveActividad(@RequestBody Actividad actividad){
        return actividadService.saveActividad(actividad);
    }

    @RequestMapping("/{id}")
    public void deleteActividad(@PathVariable Long id){
        actividadService.deleteActividad(id);
    }

}
