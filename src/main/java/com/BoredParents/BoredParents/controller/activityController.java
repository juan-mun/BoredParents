package com.BoredParents.BoredParents.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.service.activityService;

@RestController
@RequestMapping("/activities")
public class activityController {
    
    @Autowired
    private activityService activityService;

    @GetMapping("/getActivities")
    public List<Actividad> getAllActivities(){
        return activityService.getAllActivities();
    }

}
