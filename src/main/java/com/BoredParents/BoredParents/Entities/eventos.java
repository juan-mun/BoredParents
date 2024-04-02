package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento;
    private String nombre;
    private String descripcion;
    private Date fechaActividad;
    private Time horaActividad;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
     @JsonIgnoreProperties("evento")
    private List<Actividad> actividades;

    public eventos() {
    }

    public int getId_evento() {
        return id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaActividad() {
        return fechaActividad;
    }

    public Time getHoraActividad() {
        return horaActividad;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaActividad(Date fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public void setHoraActividad(Time horaActividad) {
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

}