package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.sql.Time;

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
    private List<Actividad> actividades;

    public eventos() {
    }

    public eventos(String nombre, String descripcion, Date fechaActividad, Time horaActividad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaActividad = fechaActividad;
        this.horaActividad = horaActividad;
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