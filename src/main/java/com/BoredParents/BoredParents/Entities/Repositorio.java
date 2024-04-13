package com.BoredParents.BoredParents.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Repositorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_repositorio;
    private String nombre;
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "repositorio")
    @JsonIgnoreProperties("repositorio")
    private List<Actividad> actividad;

    public Long getId_repositorio() {
        return id_repositorio;
    }

    public void setId_repositorio(Long id_repositorio) {
        this.id_repositorio = id_repositorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Actividad> getActividad() {
        return actividad;
    }

    public void setActividad(List<Actividad> actividad) {
        this.actividad = actividad;
    }

}
