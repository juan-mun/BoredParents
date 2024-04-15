package com.BoredParents.BoredParents.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Nino;
import com.BoredParents.BoredParents.repositorys.NinoRepository;

@Service
public class NinoService {
    
    @Autowired
    private NinoRepository ninoRepository;

    public List<Nino> getAllNinos(){
        return ninoRepository.getAllNinos();
    }

}
