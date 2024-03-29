package com.BoredParents.BoredParents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.entities.Activity;
import com.BoredParents.BoredParents.service.activityService;

@RestController
@RequestMapping("/activities")
public class activityController {
    
    @Autowired
    private activityService activityService;

    @GetMapping("/getActivities")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities();
    }

}