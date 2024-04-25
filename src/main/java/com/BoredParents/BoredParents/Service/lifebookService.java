package com.BoredParents.BoredParents.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.lifeBook;
import com.BoredParents.BoredParents.repositorys.lifebookRepository;

@Service
public class lifebookService {
    
    @Autowired
    private lifebookRepository lifebookRepository;

    public lifeBook saveMaterial(lifeBook material){
        return lifebookRepository.saveMaterial(material);
    }

    public void deleteMaterial(Long id){
        lifebookRepository.deleteMaterial(id);
    }


}
