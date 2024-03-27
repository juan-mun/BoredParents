package com.BoredParents.BoredParents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import com.BoredParents.BoredParents.Entity.Evento; // Asegúrate de importar tu entidad Evento correctamente

@Repository
public interface EventoRepositorio extends JpaRepository<Evento, String> {

}