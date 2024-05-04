package com.BoredParents.BoredParents.Entities;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RegistroActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_RegistroActividad;
    private LocalTime Tiempo_inicio;
    private LocalTime Tiempo_final;

    @ManyToOne
    @JoinColumn(name = "id_actividad")
    @JsonIgnoreProperties("registroActividad")
    private Actividad actividad;

    public Long getId_RegistroActividad() {
        return id_RegistroActividad;
    }

    public void setId_RegistroActividad(Long id_RegistroActividad) {
        this.id_RegistroActividad = id_RegistroActividad;
    }

    public LocalTime getTiempo_inicio() {
        return Tiempo_inicio;
    }

    public void setTiempo_inicio(LocalTime tiempo_inicio) {
        Tiempo_inicio = tiempo_inicio;
    }

    public LocalTime getTiempo_final() {
        return Tiempo_final;
    }

    public void setTiempo_final(LocalTime tiempo_final) {
        Tiempo_final = tiempo_final;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

}
