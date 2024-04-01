package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Infantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_infante;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "ID_Tutor")
    private Usuarios usuario;

    // Constructor vacío
    public Infantes() {
    }

    // Constructor con todos los campos
    public Infantes(String nombre, String apellido, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // Getters y setters para todos los campos
    public int getId_infante() {
        return id_infante;
    }

    public void setId_infante(int id_infante) {
        this.id_infante = id_infante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // Getter y setter para el usuario
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}