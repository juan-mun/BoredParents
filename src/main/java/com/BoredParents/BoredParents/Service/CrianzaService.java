package com.BoredParents.BoredParents.Service;

import com.BoredParents.BoredParents.Entities.Crianza;
import com.BoredParents.BoredParents.repositorys.resourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrianzaService {


    @Autowired
    private final resourcesRepository resourcesRepository;

    @Autowired
    public CrianzaService(resourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    public List<Crianza> getAllResources() {
        return resourcesRepository.getAllResources();
    }
}
