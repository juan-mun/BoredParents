package com.BoredParents.BoredParents.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.repositorys.ActivityRepository;

@Service
public class ActividadService {
    
    @Autowired
    private ActivityRepository activityRepository;

    public List<Actividad> getAllActividades (){
        return activityRepository.getAllActividades();
    }

    public Actividad saveActividad(Actividad actividad){
        return activityRepository.saveActividad(actividad);
    }

    public void deleteActividad (Long id){
        activityRepository.deleteActividad(id);
    }

}
