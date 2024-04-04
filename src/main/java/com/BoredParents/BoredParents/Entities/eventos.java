package com.BoredParents.BoredParents.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evento;
    private String nombre;
    private String descripcion;
    private LocalDate fechaActividad;
    private LocalTime horaActividad;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("evento")
    private List<Actividad> actividades;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaActividad() {
        return fechaActividad;
    }

    public LocalTime getHoraActividad() {
        return horaActividad;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaActividad(LocalDate fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public void setHoraActividad(LocalTime horaActividad) {
        this.horaActividad = horaActividad;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id_evento=" + id_evento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaActividad=" + fechaActividad +
                ", horaActividad=" + horaActividad +
                '}';
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }
}
