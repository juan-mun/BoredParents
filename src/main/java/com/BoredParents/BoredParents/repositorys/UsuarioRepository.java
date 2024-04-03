package com.BoredParents.BoredParents.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.BoredParents.BoredParents.Entities.Usuarios;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCRUDrepository usuarioCRUDrepository;

    // Método para encontrar un usuario por ID
    public Optional<Usuarios> findUsuarioById(Long id) {
        return usuarioCRUDrepository.findById(id);
    }

    // Método para guardar (crear o actualizar) un usuario
    public Usuarios saveUsuario(Usuarios usuario) {
        return usuarioCRUDrepository.save(usuario);
    }

    // Método para eliminar un usuario por ID
    public void deleteUsuario(Long id) {
        usuarioCRUDrepository.deleteById(id);
    }
}