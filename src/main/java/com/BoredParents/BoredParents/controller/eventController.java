package com.BoredParents.BoredParents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.entities.Event;
import com.BoredParents.BoredParents.service.eventService;

@RestController
@RequestMapping("/events")
public class eventController {

    @Autowired
    private eventService eventService;

    @GetMapping("/getEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PostMapping("/addEvents")
    public Event saveEvent(@RequestBody Event e){
        return eventService.saveEvent(e);
    }

}