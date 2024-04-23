package com.BoredParents.BoredParents.repositorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BoredParents.BoredParents.Entities.RegistroActividad;

@Repository
public class RegistroActividadRepository {

    @Autowired
    private RegistroActividadCRUDRepository registroactividadCRUDrepository;

    public RegistroActividad saveregistroactividad(RegistroActividad registroactividad) {
        return registroactividadCRUDrepository.save(registroactividad);
    }

    public List<RegistroActividad> getRegistroActividads() {
        return (List<RegistroActividad>) registroactividadCRUDrepository.findAll();
    }

}