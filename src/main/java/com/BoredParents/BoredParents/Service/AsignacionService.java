package com.BoredParents.BoredParents.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Asignacion;
import com.BoredParents.BoredParents.repositorys.AsignacionRepository;

@Service
public class AsignacionService {
    
    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<Asignacion> getAllAsignaciones(){
        return asignacionRepository.getAllAsignaciones();
    }

    public Asignacion addAsignacion(Asignacion asignacion){
        return asignacionRepository.addAsignacion(asignacion);
    }

    public void deleteAsignacion(Long id){
        asignacionRepository.deleteAsignacion(id);
    }

}
