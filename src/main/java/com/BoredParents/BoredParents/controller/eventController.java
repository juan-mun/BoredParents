package com.BoredParents.BoredParents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.eventos;
import com.BoredParents.BoredParents.service.eventService;

@RestController
@RequestMapping("/events")
public class eventController {

    @Autowired
    private eventService eventService;

    @GetMapping("/getEvents")
    public List<eventos> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PostMapping("/addEvents")
    public eventos saveEvent(@RequestBody eventos e){
        return eventService.saveEvent(e);
    }

}