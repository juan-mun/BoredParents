package com.BoredParents.BoredParents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.repositorys.activityRepository;

@Service
public class activityService {
    
    @Autowired
    private activityRepository activityRepository;

    public List<Actividad> getAllActivities(){
        return activityRepository.getAllActivitys();
    }

}
