package com.BoredParents.BoredParents.repositorys;

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
