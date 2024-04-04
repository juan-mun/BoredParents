package com.BoredParents.BoredParents.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_actividad;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    @JsonIgnoreProperties("actividades")
    private eventos evento;

    public Actividad() {
    }

    public Long getId_actividad() {
        return id_actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public eventos getEvento() {
        return evento;
    }

    public void setId_actividad(Long id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEvento(eventos evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id_actividad=" + id_actividad +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
