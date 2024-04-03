package com.BoredParents.BoredParents.Service;

import com.BoredParents.BoredParents.Entities.Infantes;
import com.BoredParents.BoredParents.repositorys.InfanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfanteService {

    private final InfanteRepository infanteRepository;

    @Autowired
    public InfanteService(InfanteRepository infanteRepository) {
        this.infanteRepository = infanteRepository;
    }

    // Método para crear o actualizar un infante
    public Infantes saveOrUpdateinfante(Infantes infante) {
        return infanteRepository.saveInfante(infante);
    }

    // Método para eliminar un infante
    public void deleteinfante(Long id) {
        infanteRepository.deleteInfante(id);
    }


}
