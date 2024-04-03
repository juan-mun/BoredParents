package com.BoredParents.BoredParents.repositorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.Actividad;

@Repository
public class activityRepository {
    
    @Autowired
    private activityCRUDrepository activityCRUDrepository;

    public List<Actividad> getAllActivitys(){
        return (List<Actividad>) activityCRUDrepository.findAll();
    }

}
