package com.BoredParents.BoredParents.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BoredParents.BoredParents.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUsername(String username);
}
