package com.BoredParents.BoredParents.repositorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.Asignacion;

@Repository
public class AsignacionRepository {

    @Autowired
    private AsignacionCRUDRepository asignacionCRUDRepository;

    public List<Asignacion> getAllAsignaciones(){
        return (List<Asignacion>) asignacionCRUDRepository.findAll();
    }

    public Asignacion addAsignacion(Asignacion asignacion){
        return asignacionCRUDRepository.save(asignacion);
    }

    public void deleteAsignacion(Long id){
        asignacionCRUDRepository.deleteById(id);
    }
    
}
