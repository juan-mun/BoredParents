package com.BoredParents.BoredParents.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Nino> getNinosByUsuarioId(Long usuarioId) {
        List<Nino> todosLosNinos = getAllNinos(); 
        List<Nino> ninosFiltrados = todosLosNinos.stream()
                                                .filter(n -> n.getUsuario() != null && n.getUsuario().getId().equals(usuarioId))
                                                .collect(Collectors.toList());
        return ninosFiltrados;
    }

    public Nino saveNino(Nino nino){
        return ninoRepository.saveNino(nino);
    }

    public void deleteNino(Long id){
        ninoRepository.deleteNino(id);
    }

}
