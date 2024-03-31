package com.BoredParents.BoredParents.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_actividad;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private eventos evento;

    public Actividad() {
    }

    public Actividad(int id_actividad, String nombre, String descripcion) {
        this.id_actividad = id_actividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_actividad() {
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

    public void setId_actividad(int id_actividad) {
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
