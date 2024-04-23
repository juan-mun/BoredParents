package com.BoredParents.BoredParents.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
<<<<<<< HEAD
=======
import jakarta.persistence.OneToOne;
>>>>>>> 165bd55d730f8671c2bddbac1d29234446c5bb0f

@Entity
public class Nino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nino;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String avatarUrl;
    private List<String> intereses;


    @OneToMany(mappedBy = "nino")
    @JsonIgnoreProperties("nino")
    private List<Asignacion> Asignaciones;

<<<<<<< HEAD
=======
    @OneToOne(mappedBy = "nino")
    private lifeBook lifeBook;
>>>>>>> 165bd55d730f8671c2bddbac1d29234446c5bb0f

    public Long getId_nino() {
        return id_nino;
    }


    public void setId_nino(Long id_nino) {
        this.id_nino = id_nino;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }


    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<Asignacion> getAsignaciones() {
        return Asignaciones;
    }


    public void setAsignaciones(List<Asignacion> asignaciones) {
        Asignaciones = asignaciones;
    }


    public List<String> getIntereses() {
        return intereses;
    }


    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

<<<<<<< HEAD
=======

    public lifeBook getLifeBook() {
        return lifeBook;
    }


    public void setLifeBook(lifeBook lifeBook) {
        this.lifeBook = lifeBook;
    }

>>>>>>> 165bd55d730f8671c2bddbac1d29234446c5bb0f
    

}
