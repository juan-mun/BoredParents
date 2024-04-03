package com.BoredParents.BoredParents.Service;

import com.BoredParents.BoredParents.Entities.Usuarios;
import com.BoredParents.BoredParents.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

   // Método para obtener un usuario por ID
    public Usuarios getUsuarioById(Long id) {
        Optional<Usuarios> usuario = usuarioRepository.findUsuarioById(id);
        if(usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
    }

    // Método para crear o actualizar un usuario
    public Usuarios saveOrUpdateUsuario(Usuarios usuario) {
        return usuarioRepository.saveUsuario(usuario);
    }

    // Método para eliminar un usuario por ID
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteUsuario(id);
    }


}
