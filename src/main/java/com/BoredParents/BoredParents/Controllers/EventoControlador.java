package com.BoredParents.BoredParents.Controllers;
import com.BoredParents.BoredParents.Entity.Evento;
import com.BoredParents.BoredParents.Service.EventoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoControlador {
    private final EventoServicio eventoServicio;

    @Autowired
    public EventoControlador(EventoServicio eventoServicio) {
        this.eventoServicio = eventoServicio;
    }

    @PostMapping
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        Evento nuevoEvento = eventoServicio.crearEvento(evento);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerEventoPorId(@PathVariable String id) {
        return eventoServicio.buscarPorId(id)
                .map(evento -> new ResponseEntity<>(evento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarTodosLosEventos() {
        List<Evento> eventos = eventoServicio.listarTodosLosEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizarEvento(@RequestBody Evento evento, @PathVariable String id) {
        if (eventoServicio.buscarPorId(id).isPresent()) {
            evento.setId(id); // Asegúrate de que la entidad Evento tenga un setter para ID.
            Evento eventoActualizado = eventoServicio.actualizarEvento(evento);
            return new ResponseEntity<>(eventoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable String id) {
        if (eventoServicio.buscarPorId(id).isPresent()) {
            eventoServicio.eliminarEvento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
