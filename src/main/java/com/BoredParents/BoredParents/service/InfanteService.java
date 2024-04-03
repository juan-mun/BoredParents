package com.BoredParents.BoredParents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Infantes;
import com.BoredParents.BoredParents.repositorys.InfanteRepository;

@Service
public class InfanteService {
    
    @Autowired
    private InfanteRepository infanteRepository;

    public List<Infantes> getInfantes(){
        return infanteRepository.getAllInfantes();
    }

    public Infantes saveInfantes(Infantes infante){
        return infanteRepository.saveInfante(infante);
    }

    public void deleteInfante(Long id){
        infanteRepository.deleteInfante(id);
    }
}
