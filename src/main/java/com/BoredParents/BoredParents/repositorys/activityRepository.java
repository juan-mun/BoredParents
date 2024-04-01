package com.BoredParents.BoredParents.repositorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class activityRepository {
    
    @Autowired
    private activityCRUDrepository activityCRUDrepository;

    public List<Activity> getAllActivitys(){
        return (List<Activity>) activityCRUDrepository.findAll();
    }

}
