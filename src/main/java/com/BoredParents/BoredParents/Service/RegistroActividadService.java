package com.BoredParents.BoredParents.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.RegistroActividad;
import com.BoredParents.BoredParents.repositorys.RegistroActividadRepository;

@Service
public class RegistroActividadService {

    @Autowired
    private RegistroActividadRepository registroactividadRepository;

    public RegistroActividad saveregistroactividad(RegistroActividad registroactividad) {
        return registroactividadRepository.saveregistroactividad(registroactividad);
    }

    public List<RegistroActividad> getRegistroActividads() {
        return registroactividadRepository.getRegistroActividads();
    }

    public List<RegistroActividad> getRegistroActividadsById(Long id) {
        List<RegistroActividad> allRegistroActividades = registroactividadRepository.getRegistroActividads();
        return allRegistroActividades.stream()
                .filter(registro -> registro.getAsignacion().getId_asignacion().equals(id))
                .collect(Collectors.toList());
    }    

}
