package com.BoredParents.BoredParents.controller;

import com.BoredParents.BoredParents.Entities.Usuarios;
import com.BoredParents.BoredParents.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuarios")
public class usuarioController {

    @Autowired
    private UsuarioService UsuarioService;

    @PostMapping("/addUsuarios")
    public Usuarios saveOrUpdateUsuario(@RequestBody Usuarios u){
        return UsuarioService.saveOrUpdateUsuario(u);
    }

    @PutMapping("/updateUsuarios")
    public Usuarios updateUsuario(@RequestBody Usuarios u){
        return UsuarioService.saveOrUpdateUsuario(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id){
        UsuarioService.deleteUsuario(id);
    }

}