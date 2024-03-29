package com.BoredParents.BoredParents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.entities.Activity;
import com.BoredParents.BoredParents.repositorys.activityRepository;

@Service
public class activityService {
    
    @Autowired
    private activityRepository activityRepository;

    public List<Activity> getAllActivities(){
        return activityRepository.getAllActivitys();
    }

}
