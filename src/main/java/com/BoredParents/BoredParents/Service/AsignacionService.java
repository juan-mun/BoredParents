package com.BoredParents.BoredParents.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.Entities.Asignacion;
import com.BoredParents.BoredParents.repositorys.AsignacionRepository;

@Service
public class AsignacionService {
    
    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<Asignacion> getAllAsignaciones(){
        return asignacionRepository.getAllAsignaciones();
    }
    
    // Método para obtener actividades por el ID de niño
    public List<Actividad> getActividadesByNinoId(Long ninoId) {
        List<Asignacion> asignaciones = getAllAsignaciones();
        List<Actividad> actividadesFiltradas = asignaciones.stream()
                                                            .filter(a -> a.getNino().getId_nino().equals(ninoId))
                                                            .map(Asignacion::getActividad)
                                                            .collect(Collectors.toList());
        return actividadesFiltradas;
    }

    public Asignacion addAsignacion(Asignacion asignacion){
        return asignacionRepository.addAsignacion(asignacion);
    }

    public void deleteAsignacion(Long id){
        asignacionRepository.deleteAsignacion(id);
    }

}
