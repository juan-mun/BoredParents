package com.BoredParents.BoredParents.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.BoredParents.BoredParents.Entities.Actividad;
import com.BoredParents.BoredParents.Entities.Nino;
import com.BoredParents.BoredParents.Service.RecomendacionService;
import com.BoredParents.BoredParents.repositorys.ActivityCRUDRepository;
import com.BoredParents.BoredParents.repositorys.NinoCRUDRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @Autowired
    private NinoCRUDRepository ninoCRUDRepository; // Suponiendo que tienes un repositorio para la entidad Nino

    @Autowired
    private ActivityCRUDRepository activityCRUDRepository; // Suponiendo que tienes un repositorio para la entidad
                                                           // Actividad

    @GetMapping("/recomendar-actividades")
    public String recomendarActividades(Model model, Long idNino) {
        // Obtener el niño de la base de datos
        Nino nino = ninoCRUDRepository.findById(idNino).orElse(null);
        if (nino == null) {
            // Manejar el caso en que el niño no existe
            return "error"; // Puedes redirigir a una página de error o manejarlo de otra manera
        }

        // Obtener los intereses del niño
        List<String> interesesDelNino = nino.getIntereses();

        // Obtener todas las actividades y convertirlas a una lista
        List<Actividad> todasLasActividades = StreamSupport
                .stream(activityCRUDRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // Recomendar actividades basadas en los intereses del niño
        List<Actividad> actividadesRecomendadas = recomendacionService.recomendarActividades(todasLasActividades,
                idNino);

        // Agregar las actividades recomendadas al modelo para mostrarlas en la vista
        model.addAttribute("actividadesRecomendadas", actividadesRecomendadas);

        // Devolver el nombre de la vista donde mostrar las actividades recomendadas
        return "actividadesRecomendadas"; // Suponiendo que tienes una vista llamada actividadesRecomendadas.html
    }
}