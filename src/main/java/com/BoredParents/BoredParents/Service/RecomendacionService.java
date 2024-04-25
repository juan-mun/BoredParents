package com.BoredParents.BoredParents.Service;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.Entities.Nino;
import com.BoredParents.BoredParents.repositorys.NinoCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacionService {

    @Autowired
    private NinoCRUDRepository ninoCRUDRepository;

    public List<Actividad> recomendarActividades(List<Actividad> actividades, Long id_Nino) {
        Nino nino = ninoCRUDRepository.findById(id_Nino).orElse(null);
        if (nino == null) {
            return null; // o maneja este caso como prefieras
        }
        List<String> interesesDelNino = nino.getIntereses();

        // Filtrar actividades basadas en intereses del niño
        return actividades.stream()
                .filter(actividad -> tieneInteres(actividad, interesesDelNino))
                .sorted((a1, a2) -> calcularRelevancia(nino, interesesDelNino) - calcularRelevancia(nino, interesesDelNino))
                .collect(Collectors.toList());
    }

    // Método para obtener los intereses de un niño por su ID
    public List<String> getInteresesDelNino(Long id_Nino) {
        Nino nino = ninoCRUDRepository.findById(id_Nino).orElse(null);
        return (nino != null) ? nino.getIntereses() : null;
    }

    private boolean tieneInteres(Actividad actividad, List<String> interesesDelNino) {
        // Implementa la lógica para comprobar si la actividad tiene interés para el niño
        // Devuelve true o false
        return true; // Devuelve true como un marcador de posición
    }

    private int calcularRelevancia(Nino nino, List<String> interesesDelNino) {
        // Calcular la relevancia de la actividad basada en la cantidad de intereses en
        // común con los del niño
        return (int) nino.getIntereses().stream().filter(interesesDelNino::contains).count();
    }
}
