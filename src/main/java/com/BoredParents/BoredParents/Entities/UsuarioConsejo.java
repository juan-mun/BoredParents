package com.BoredParents.BoredParents.Entities;

import jakarta.persistence.*;

@Entity
public class UsuarioConsejo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "consejo_id")
    private Consejo consejo;

    // Constructor vacío
    public UsuarioConsejo() {
    }

    // Getters y setters para todos los campos
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Consejo getConsejo() {
        return consejo;
    }

    public void setConsejo(Consejo consejo) {
        this.consejo = consejo;
    }
}
