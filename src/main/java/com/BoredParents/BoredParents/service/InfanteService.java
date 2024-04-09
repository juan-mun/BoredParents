<<<<<<< HEAD
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


=======
package com.BoredParents.BoredParents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Infantes;
import com.BoredParents.BoredParents.repositorys.InfanteRepository;

@Service
public class InfanteService {
    
    @Autowired
    private InfanteRepository infanteRepository;

    public List<Infantes> getInfantes(){
        return infanteRepository.getAllInfantes();
    }

    public Infantes saveInfantes(Infantes infante){
        return infanteRepository.saveInfante(infante);
    }

    public void deleteInfante(Long id){
        infanteRepository.deleteInfante(id);
    }
>>>>>>> 91a23a9753bed70d84ccf03050a6417ff21f5ece
}
