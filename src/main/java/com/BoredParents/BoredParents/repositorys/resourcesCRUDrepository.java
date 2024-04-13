package com.BoredParents.BoredParents.repositorys;

import com.BoredParents.BoredParents.Entities.Crianza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface resourcesCRUDrepository extends JpaRepository<Crianza, Long> {
    // No es necesario agregar métodos adicionales aquí, JpaRepository incluye findAll()
}
