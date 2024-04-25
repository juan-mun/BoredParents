
package com.BoredParents.BoredParents.Controller;

import com.BoredParents.BoredParents.Entities.RegistroActividad;
import com.BoredParents.BoredParents.Service.RegistroActividadService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RegistroActividadController")
public class RegistroActividadController {

    @Autowired
    private RegistroActividadService RegistroActividadService;

    @PostMapping("/save")
    public RegistroActividad saveregistroactividad(@RequestBody RegistroActividad registroactividad) {
        return RegistroActividadService.saveregistroactividad(registroactividad);
    }

    @GetMapping("/registrosPorActividades/{id}")
    public List<RegistroActividad> getRegistroActividadesById(@PathVariable Long id) {
        return RegistroActividadService.getRegistroActividadsById(id);
    }

    @GetMapping("/get")
    public List<RegistroActividad> getRegistroActividads() {
        return RegistroActividadService.getRegistroActividads();
    }

}
