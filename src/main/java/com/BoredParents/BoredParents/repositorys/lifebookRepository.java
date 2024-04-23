package com.BoredParents.BoredParents.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.lifeBook;

@Repository
public class lifebookRepository {
    
    @Autowired
    private lifebookCRUDRepository lifebookCRUDRepository;

    public lifeBook saveMaterial(lifeBook material){
        return lifebookCRUDRepository.save(material);
    }

    public void deleteMaterial(Long id){
        lifebookCRUDRepository.deleteById(id);
    }

}
