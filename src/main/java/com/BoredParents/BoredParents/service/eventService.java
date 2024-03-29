package com.BoredParents.BoredParents.service;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.entities.Event;
import com.BoredParents.BoredParents.repositorys.eventRepository;

@Service
public class eventService {
    
    @Autowired
    private eventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.getAllEvents();  
    }

    public Event saveEvent(Event e){
        return eventRepository.save(e);
    }
}
