package com.BoredParents.BoredParents.repositorys;

import com.BoredParents.BoredParents.Entities.Infantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InfanteRepository {

    @Autowired
    private InfanteCRUDrepository InfanteCRUDrepository;

    // Método para guardar (crear o actualizar) un infante
    public Infantes saveInfante(Infantes infantes) {
        return InfanteCRUDrepository.save(infantes);
    }

    // Método para eliminar un infante por ID
    public void deleteInfante(Long id) {
        InfanteCRUDrepository.deleteById(id);
    }
}