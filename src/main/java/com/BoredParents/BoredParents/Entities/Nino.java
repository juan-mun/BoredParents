package com.BoredParents.BoredParents.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Nino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nino;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String avatarUrl;
    private List<String> intereses;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties("usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "nino")
    @JsonManagedReference // Agregamos esta anotación
    private List<Asignacion> asignaciones;

    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @OneToOne(mappedBy = "nino")
    private lifeBook lifeBook;

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
        return asignaciones;
    }


    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }


    public List<String> getIntereses() {
        return intereses;
    }


    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }


    public lifeBook getLifeBook() {
        return lifeBook;
    }


    public void setLifeBook(lifeBook lifeBook) {
        this.lifeBook = lifeBook;
    }

    

}
