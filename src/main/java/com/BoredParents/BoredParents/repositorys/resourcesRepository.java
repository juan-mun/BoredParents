package com.BoredParents.BoredParents.repositorys;

import com.BoredParents.BoredParents.Entities.Crianza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class resourcesRepository {

    private final resourcesCRUDrepository resourcesCRUDrepository;

    @Autowired
    public resourcesRepository(resourcesCRUDrepository resourcesCRUDrepository) {
        this.resourcesCRUDrepository = resourcesCRUDrepository;
    }

    public List<Crianza> getAllResources() {
        return resourcesCRUDrepository.findAll();
    }
}
