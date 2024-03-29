package com.BoredParents.BoredParents.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.BoredParents.BoredParents.entities.Event;
import java.util.List;

@Repository
public class eventRepository {

    @Autowired
    private eventCRUDrepository eventCRUDrepository;

    public List<Event> getAllEvents(){
        return (List<Event>) eventCRUDrepository.findAll();
    }

    public Event save(Event e){
        return eventCRUDrepository.save(e);
    }
    
}
