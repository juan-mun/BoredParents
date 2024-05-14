package com.BoredParents.BoredParents.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.Entities.Asignacion;
import com.BoredParents.BoredParents.Service.AsignacionService;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {
    
    @Autowired
    private AsignacionService asignacionService;

    @GetMapping("/getAsignaciones")
    public List<Asignacion> getAllAsignaciones(){
        return asignacionService.getAllAsignaciones();  
    }

    @PostMapping("/addAsignacion")
    public Asignacion addAsignacion(@RequestBody Asignacion asignacion){
        return asignacionService.addAsignacion(asignacion);
    }

    @GetMapping("/actividadesPorNino/{ninoId}")
    public List<Actividad> getActividadesByNinoId(@PathVariable Long ninoId) {
        return asignacionService.getActividadesByNinoId(ninoId);
    }

    @DeleteMapping("/{id}")
    public void deleteAsignacion(@PathVariable Long id){
        asignacionService.deleteAsignacion(id);
    }


}