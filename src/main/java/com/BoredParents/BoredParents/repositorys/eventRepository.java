package com.BoredParents.BoredParents.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.eventos;

import java.util.List;

@Repository
public class eventRepository {

    @Autowired
    private eventCRUDrepository eventCRUDrepository;

    public List<eventos> getAllEvents(){
        return (List<eventos>) eventCRUDrepository.findAll();
    }

    public eventos save(eventos e){
        return eventCRUDrepository.save(e);
    }
    
}
