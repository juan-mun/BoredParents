package com.BoredParents.BoredParents.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.Recursos;

import java.util.List;

@Repository
public class RecursosRepository {
    
    @Autowired
    private RecursosCRUDRepository recursosCRUDRepository;

    public List<Recursos> getAllRecursos(){
        return (List<Recursos>) recursosCRUDRepository.findAll();
    }

    public Recursos saveRecursos(Recursos recurso){
        return recursosCRUDRepository.save(recurso);
    }

}
