package com.BoredParents.BoredParents.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> 165bd55d730f8671c2bddbac1d29234446c5bb0f

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.BoredParents.BoredParents.Entities.Actividad;
=======
>>>>>>> 165bd55d730f8671c2bddbac1d29234446c5bb0f
import com.BoredParents.BoredParents.Entities.Asignacion;
import com.BoredParents.BoredParents.repositorys.AsignacionRepository;

@Service
public class AsignacionService {
    
    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<Asignacion> getAllAsignaciones(){
        return asignacionRepository.getAllAsignaciones();
    }
    
<<<<<<< HEAD
    // Método para obtener actividades por el ID de niño
    public List<Actividad> getActividadesByNinoId(Long ninoId) {
        List<Asignacion> asignaciones = getAllAsignaciones();
        List<Actividad> actividadesFiltradas = asignaciones.stream()
                                                            .filter(a -> a.getNino().getId_nino().equals(ninoId))
                                                            .map(Asignacion::getActividad)
                                                            .collect(Collectors.toList());
        return actividadesFiltradas;
    }

=======
>>>>>>> 165bd55d730f8671c2bddbac1d29234446c5bb0f
    public Asignacion addAsignacion(Asignacion asignacion){
        return asignacionRepository.addAsignacion(asignacion);
    }

    public void deleteAsignacion(Long id){
        asignacionRepository.deleteAsignacion(id);
    }

}
