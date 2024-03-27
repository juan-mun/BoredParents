package com.BoredParents.BoredParents.Service;

import com.BoredParents.BoredParents.Entity.Evento;
import com.BoredParents.BoredParents.Repository.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServicio {
    private final EventoRepositorio eventoRepositorio;

    @Autowired
    public EventoServicio(EventoRepositorio eventoRepositorio) {
        this.eventoRepositorio = eventoRepositorio;
    }

    public Evento crearEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    public Optional<Evento> buscarPorId(String id) {
        return eventoRepositorio.findById(id);
    }

    public List<Evento> listarTodosLosEventos() {
        return eventoRepositorio.findAll();
    }

    public Evento actualizarEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    public void eliminarEvento(String id) {
        eventoRepositorio.deleteById(id);
    }
}
