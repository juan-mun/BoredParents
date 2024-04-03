package com.BoredParents.BoredParents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.eventos;
import com.BoredParents.BoredParents.repositorys.eventRepository;

@Service
public class eventService {
    
    @Autowired
    private eventRepository eventRepository;

    public List<eventos> getAllEvents(){
        return eventRepository.getAllEvents();  
    }

    public eventos saveEvent(eventos e){
        return eventRepository.save(e);
    }

    public void deleteEvent(Long id){
        eventRepository.delete(id);
    }
}
