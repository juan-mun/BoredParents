package com.BoredParents.BoredParents.repositorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.Nino;

@Repository
public class NinoRepository {
    
    @Autowired
    private NinoCRUDRepository ninoCRUDRepository;

    public List<Nino> getAllNinos(){
        return (List<Nino>) ninoCRUDRepository.findAll();
    }

    public Nino saveNino(Nino nino){
        return ninoCRUDRepository.save(nino);
    }

    public void deleteNino(Long id){
        ninoCRUDRepository.deleteById(id);
    } 
}
