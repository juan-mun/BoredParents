package com.BoredParents.BoredParents.repositorys;

import com.BoredParents.BoredParents.Entities.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioCRUDrepository extends CrudRepository<Usuarios, Long> {
    // Spring Data proporciona operaciones CRUD básicas.
}
