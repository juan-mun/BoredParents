package com.BoredParents.BoredParents.repositorys;

<<<<<<< HEAD
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
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.Infantes;

@Repository
public class InfanteRepository {
    
    @Autowired
    private InfanteCRUDrepository InfanteCRUDrepository;

    public List<Infantes> getAllInfantes(){
        return (List<Infantes>) InfanteCRUDrepository.findAll();
    }

    public Infantes saveInfante(Infantes infante){
        return InfanteCRUDrepository.save(infante);
    }

    public void deleteInfante(Long id){
        InfanteCRUDrepository.deleteById(id);
    }

}
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece
