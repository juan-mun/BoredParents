package com.BoredParents.BoredParents.repositorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.Actividad;

@Repository
public class ActivityRepository{
    
    @Autowired
    private ActivityCRUDRepository activityCRUDRepository;

    public List<Actividad> getAllActividades(){
        return (List<Actividad>) activityCRUDRepository.findAll();
    }

    public Actividad saveActividad(Actividad actividad){
        return activityCRUDRepository.save(actividad);
    }

    public void deleteActividad(Long id){
        activityCRUDRepository.deleteById(id);
    }

}
