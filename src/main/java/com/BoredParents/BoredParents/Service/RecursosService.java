package com.BoredParents.BoredParents.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Recursos;
import com.BoredParents.BoredParents.repositorys.RecursosRepository;

import java.util.List;

@Service
public class RecursosService {
    
    @Autowired
    private RecursosRepository recursosRepository;

    public List<Recursos> getAllRecursos(){
        return recursosRepository.getAllRecursos();
    }

    public Recursos saveRecurso(Recursos recurso){
        return recursosRepository.saveRecursos(recurso);
    }

}
