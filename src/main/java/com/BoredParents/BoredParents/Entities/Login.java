package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

@Entity
public class Login {
    @Id
    private int id_login;
    private String correo;
    private String contraseña;
    private int ultimo_acceso;

    @OneToOne
    @JoinColumn(name = "ID_Tutor")
    private Usuarios usuario;

    // Getters y setters para todos los campos
    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(int ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    // Getter y setter para el usuario
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}